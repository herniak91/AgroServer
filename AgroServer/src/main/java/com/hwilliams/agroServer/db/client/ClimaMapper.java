package com.hwilliams.agroServer.db.client;

import com.hwilliams.agroServer.db.model.Clima;
import com.hwilliams.agroServer.db.model.ClimaExample;
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

public interface ClimaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @SelectProvider(type=ClimaSqlProvider.class, method="countByExample")
    int countByExample(ClimaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @DeleteProvider(type=ClimaSqlProvider.class, method="deleteByExample")
    int deleteByExample(ClimaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @Insert({
        "insert into clima (latitud, longitud, ",
        "temperatura, sensacion_termica, ",
        "descripcion, viento, ",
        "humedad, probabilidad_lluvia)",
        "values (#{latitud,jdbcType=REAL}, #{longitud,jdbcType=REAL}, ",
        "#{temperatura,jdbcType=SMALLINT}, #{sensacionTermica,jdbcType=SMALLINT}, ",
        "#{descripcion,jdbcType=VARCHAR}, #{viento,jdbcType=SMALLINT}, ",
        "#{humedad,jdbcType=SMALLINT}, #{probabilidadLluvia,jdbcType=SMALLINT})"
    })
    int insert(Clima record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @InsertProvider(type=ClimaSqlProvider.class, method="insertSelective")
    int insertSelective(Clima record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @SelectProvider(type=ClimaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="latitud", property="latitud", jdbcType=JdbcType.REAL),
        @Result(column="longitud", property="longitud", jdbcType=JdbcType.REAL),
        @Result(column="temperatura", property="temperatura", jdbcType=JdbcType.SMALLINT),
        @Result(column="sensacion_termica", property="sensacionTermica", jdbcType=JdbcType.SMALLINT),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="viento", property="viento", jdbcType=JdbcType.SMALLINT),
        @Result(column="humedad", property="humedad", jdbcType=JdbcType.SMALLINT),
        @Result(column="probabilidad_lluvia", property="probabilidadLluvia", jdbcType=JdbcType.SMALLINT)
    })
    List<Clima> selectByExample(ClimaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @UpdateProvider(type=ClimaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Clima record, @Param("example") ClimaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clima
     *
     * @mbggenerated Fri May 27 21:07:43 ART 2016
     */
    @UpdateProvider(type=ClimaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Clima record, @Param("example") ClimaExample example);
}