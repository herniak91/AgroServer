package com.hwilliams.agroServer.service;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.db.client.UsuarioMapper;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.db.model.UsuarioExample;

@Service
public class PerfilService {

	@Autowired
	private UsuarioMapper dao;

	public Usuario crearPerfil(Usuario user) {
		if (null != user.getId())
			throw new RuntimeException("Usuario ya tiene id [" + user.getId() + "]. No se puede crear");
		PasswordEncryptor encryptor = createEncryptor();
		user.setPassword(encryptor.encryptPassword(user.getPassword()));
		dao.insert(user);
		return user;
	}

	public Usuario loginUsuario(Integer id, String password) {
		Usuario user = buscarUsuario(id);
		checkPassword(password, user.getPassword());
		return user;
	}

	public void actualizarPerfil(Usuario user, Usuario modifaciones) {
		if (null == user.getId())
			throw new RuntimeException("Usuario no tiene id. No se puede actualizar");
		Usuario usuarioActual = buscarUsuario(user.getId());
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andNombreEqualTo(modifaciones.getNombre()).andApellidoEqualTo(modifaciones.getApellido())
				.andTelefonoEqualTo(modifaciones.getTelefono()).andEmailEqualTo(modifaciones.getEmail());
		dao.updateByExampleSelective(usuarioActual, example);
	}

	public void borrarPerfil(Integer userId) {
		Integer usuariosBorrados = dao.deleteByPrimaryKey(userId);
		if (usuariosBorrados != 1)
			throw new RuntimeException("Error borrando usuario de id [" + userId + "]. Se encontraron [" + usuariosBorrados
					+ "] en la base de datos");
	}

	private void actualizarContrasenia(Usuario user, String newPassword) {

	}

	private void checkPassword(String newPassword, String oldPassword) {
		PasswordEncryptor passwordEncryptor = createEncryptor();
		if (!passwordEncryptor.checkPassword(newPassword, oldPassword))
			throw new RuntimeException("Contraseña incorrecta");
	}

	private PasswordEncryptor createEncryptor() {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor;
	}

	private Usuario buscarUsuario(Integer id) {
		Usuario usuario = dao.selectByPrimaryKey(id);
		if (usuario == null)
			throw new RuntimeException("Usuario de id [" + id + "] no encontrado en la base de datos");
		return usuario;
	}

}
