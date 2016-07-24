package com.hwilliams.agroServer.db.model;

public class ParqueMaquina {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parque_maquina.id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parque_maquina.rubro
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    private String rubro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parque_maquina.usuario_id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    private Integer usuarioId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parque_maquina.maquinas_json
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    private String maquinasJson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parque_maquina.estado
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    private String estado;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parque_maquina.id
     *
     * @return the value of parque_maquina.id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parque_maquina.id
     *
     * @param id the value for parque_maquina.id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parque_maquina.rubro
     *
     * @return the value of parque_maquina.rubro
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public String getRubro() {
        return rubro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parque_maquina.rubro
     *
     * @param rubro the value for parque_maquina.rubro
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public void setRubro(String rubro) {
        this.rubro = rubro == null ? null : rubro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parque_maquina.usuario_id
     *
     * @return the value of parque_maquina.usuario_id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parque_maquina.usuario_id
     *
     * @param usuarioId the value for parque_maquina.usuario_id
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parque_maquina.maquinas_json
     *
     * @return the value of parque_maquina.maquinas_json
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public String getMaquinasJson() {
        return maquinasJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parque_maquina.maquinas_json
     *
     * @param maquinasJson the value for parque_maquina.maquinas_json
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public void setMaquinasJson(String maquinasJson) {
        this.maquinasJson = maquinasJson == null ? null : maquinasJson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parque_maquina.estado
     *
     * @return the value of parque_maquina.estado
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public String getEstado() {
        return estado;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parque_maquina.estado
     *
     * @param estado the value for parque_maquina.estado
     *
     * @mbggenerated Tue Jul 19 14:30:03 ART 2016
     */
    public void setEstado(String estado) {
        this.estado = estado == null ? null : estado.trim();
    }
}