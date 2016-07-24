package com.hwilliams.agroServer.service;

import java.util.List;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.db.client.UsuarioMapper;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.db.model.UsuarioExample;
import com.hwilliams.agroServer.service.exception.LoginException;

@Service
public class PerfilService {

	@Autowired
	private UsuarioMapper dao;

	public Usuario crearPerfil(Usuario user) {
		if (null != user.getId()){
			System.out.println("Usuario ya tiene id [" + user.getId() + "]. No se puede crear");
			throw new LoginException("Usuario existente");
		}
		PasswordEncryptor encryptor = createEncryptor();
		String plainPassword = new String(user.getPassword());
		user.setPassword(encryptor.encryptPassword(user.getPassword()));
		dao.insert(user);
		user.setPassword(plainPassword);
		return user;
	}

	public Usuario loginUsuario(String username, String password) {
		Usuario user = buscarUsuario(username);
		checkPassword(password, user.getPassword());
		return user;
	}

	public void actualizarPerfil(Usuario user, Usuario modifaciones) {
		Usuario usuarioActual = buscarUsuario(user.getUsername());
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andNombreEqualTo(modifaciones.getNombre()).andApellidoEqualTo(modifaciones.getApellido())
				.andTelefonoEqualTo(modifaciones.getTelefono()).andEmailEqualTo(modifaciones.getEmail());
		dao.updateByExampleSelective(usuarioActual, example);
	}
	
	public boolean verificarUsername(String username){
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andUsernameEqualTo(username);
		if(dao.selectByExample(example).size() > 0)
			return false;
		return true;
	}

	public void borrarPerfil(String username) {
		Integer usuariosBorrados = dao.deleteByPrimaryKey(buscarUsuario(username).getId());
		if (usuariosBorrados != 1){
			System.out.println("Error borrando usuario de id [" + buscarUsuario(username).getId() + "]. Se encontraron [" + usuariosBorrados + "] en la base de datos");
			throw new LoginException("Usuario no encontrado");
		}
	}

	public void actualizarContrasenia(String username, String newPassword) {
		Usuario user = buscarUsuario(username);
		PasswordEncryptor encryptor = createEncryptor();
		user.setPassword(encryptor.encryptPassword(newPassword));
		dao.updateByPrimaryKey(user);
	}

	private void checkPassword(String newPassword, String oldPassword) {
		PasswordEncryptor passwordEncryptor = createEncryptor();
		if (!passwordEncryptor.checkPassword(newPassword, oldPassword))
			throw new LoginException("Contraseña incorrecta");
	}

	private PasswordEncryptor createEncryptor() {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor;
	}

	public Usuario buscarUsuario(String username){
		if("".equalsIgnoreCase(username))
			throw new LoginException("Username vacio");
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<Usuario> list = dao.selectByExample(example);
		if(list.size() != 1){
			System.out.println("Se encontraron [" + list.size() + "] con username " + username);
			throw new LoginException("Usuario no encontrado");
		}
		return list.get(0);
	}

}
