package com.hwilliams.agroServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwilliams.agroServer.db.client.UsuarioMapper;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.db.model.UsuarioExample;

@Service
@Transactional
public class PerfilService {

	@Autowired
	private UsuarioMapper dao;

	public void crearPerfil(Usuario user) {
		dao.insert(user);
	}

	public void actualizarPerfil(Integer userIdActual, Usuario modifaciones){
		Usuario usuarioActual = dao.selectByPrimaryKey(userIdActual);
		if(usuarioActual == null)
			throw new RuntimeException("Usuario de id [" + userIdActual + "] no encontrado en la base de datos");
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andNombreEqualTo(modifaciones.getNombre()).andApellidoEqualTo(modifaciones.getApellido()).andTelefono1EqualTo(modifaciones.getTelefono1()).andTelefono2EqualTo(modifaciones.getTelefono2()).andEmailEqualTo(modifaciones.getEmail());
		dao.updateByExampleSelective(usuarioActual, example);
	}

	public void borrarPerfil(Integer userId) {
		Integer usuariosBorrados = dao.deleteByPrimaryKey(userId);
		if (usuariosBorrados != 1)
			throw new RuntimeException("Error borrando usuario de id [" + userId + "]. Se encontraron [" + usuariosBorrados
					+ "] en la base de datos");
	}
}
