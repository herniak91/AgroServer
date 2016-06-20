package com.hwilliams.agroServer.db.model;

import java.util.Date;

public class Prestacion {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.propietario_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Integer propietarioId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.maquina_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Integer maquinaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.fecha_desde
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Date fechaDesde;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.fecha_hasta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Date fechaHasta;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.cliente_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private Integer clienteId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prestacion.estado
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    private String estado;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.id
     *
     * @return the value of prestacion.id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.id
     *
     * @param id the value for prestacion.id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.propietario_id
     *
     * @return the value of prestacion.propietario_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Integer getPropietarioId() {
        return propietarioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.propietario_id
     *
     * @param propietarioId the value for prestacion.propietario_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setPropietarioId(Integer propietarioId) {
        this.propietarioId = propietarioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.maquina_id
     *
     * @return the value of prestacion.maquina_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Integer getMaquinaId() {
        return maquinaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.maquina_id
     *
     * @param maquinaId the value for prestacion.maquina_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setMaquinaId(Integer maquinaId) {
        this.maquinaId = maquinaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.fecha_desde
     *
     * @return the value of prestacion.fecha_desde
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.fecha_desde
     *
     * @param fechaDesde the value for prestacion.fecha_desde
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.fecha_hasta
     *
     * @return the value of prestacion.fecha_hasta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.fecha_hasta
     *
     * @param fechaHasta the value for prestacion.fecha_hasta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.cliente_id
     *
     * @return the value of prestacion.cliente_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Integer getClienteId() {
        return clienteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.cliente_id
     *
     * @param clienteId the value for prestacion.cliente_id
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prestacion.estado
     *
     * @return the value of prestacion.estado
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String getEstado() {
        return estado;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prestacion.estado
     *
     * @param estado the value for prestacion.estado
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setEstado(String estado) {
        this.estado = estado == null ? null : estado.trim();
    }
}