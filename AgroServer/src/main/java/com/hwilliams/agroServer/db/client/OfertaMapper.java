package com.hwilliams.agroServer.db.client;

import com.hwilliams.agroServer.db.model.Oferta;
import com.hwilliams.agroServer.db.model.OfertaExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OfertaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @SelectProvider(type=OfertaSqlProvider.class, method="countByExample")
    int countByExample(OfertaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @DeleteProvider(type=OfertaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OfertaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @Insert({
        "insert into oferta (usuario_id, maquina_id, ",
        "latitud, longitud, disponibilidad_desde, ",
        "disponibilidad_hasta, estado)",
        "values (#{usuarioId,jdbcType=INTEGER}, #{maquinaId,jdbcType=INTEGER}, ",
        "#{latitud,jdbcType=REAL}, #{longitud,jdbcType=REAL}, #{disponibilidadDesde,jdbcType=DATE}, ",
        "#{disponibilidadHasta,jdbcType=DATE}, #{estado,jdbcType=VARCHAR})"
    })
    int insert(Oferta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @InsertProvider(type=OfertaSqlProvider.class, method="insertSelective")
    int insertSelective(Oferta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @SelectProvider(type=OfertaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="usuario_id", property="usuarioId", jdbcType=JdbcType.INTEGER),
        @Result(column="maquina_id", property="maquinaId", jdbcType=JdbcType.INTEGER),
        @Result(column="latitud", property="latitud", jdbcType=JdbcType.REAL),
        @Result(column="longitud", property="longitud", jdbcType=JdbcType.REAL),
        @Result(column="disponibilidad_desde", property="disponibilidadDesde", jdbcType=JdbcType.DATE),
        @Result(column="disponibilidad_hasta", property="disponibilidadHasta", jdbcType=JdbcType.DATE),
        @Result(column="estado", property="estado", jdbcType=JdbcType.VARCHAR)
    })
    List<Oferta> selectByExample(OfertaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @UpdateProvider(type=OfertaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Oferta record, @Param("example") OfertaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    @UpdateProvider(type=OfertaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Oferta record, @Param("example") OfertaExample example);
}