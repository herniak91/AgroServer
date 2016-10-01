package com.hwilliams.agroServer.db.client;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.db.model.ParqueMaquinaExample;

public interface ParqueMaquinaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @SelectProvider(type=ParqueMaquinaSqlProvider.class, method="countByExample")
    int countByExample(ParqueMaquinaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @DeleteProvider(type=ParqueMaquinaSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParqueMaquinaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @Delete({
        "delete from parque_maquina",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @Insert({
        "insert into parque_maquina (id, rubro, ",
        "usuario_id, maquinas_json, ",
        "estado, lat, lon)",
        "values (#{id,jdbcType=INTEGER}, #{rubro,jdbcType=VARCHAR}, ",
        "#{usuarioId,jdbcType=INTEGER}, #{maquinasJson,jdbcType=VARCHAR}, ",
        "#{estado,jdbcType=VARCHAR}, #{lat,jdbcType=REAL}, #{lon,jdbcType=REAL})"
    })
    @SelectKey(statement="SELECT nextVal('parque_maquina_id_seq')", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ParqueMaquina record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @InsertProvider(type=ParqueMaquinaSqlProvider.class, method="insertSelective")
    int insertSelective(ParqueMaquina record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @SelectProvider(type=ParqueMaquinaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rubro", property="rubro", jdbcType=JdbcType.VARCHAR),
        @Result(column="usuario_id", property="usuarioId", jdbcType=JdbcType.INTEGER),
        @Result(column="maquinas_json", property="maquinasJson", jdbcType=JdbcType.VARCHAR),
        @Result(column="estado", property="estado", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.REAL),
        @Result(column="lon", property="lon", jdbcType=JdbcType.REAL)
    })
    List<ParqueMaquina> selectByExample(ParqueMaquinaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @Select({
        "select",
        "id, rubro, usuario_id, maquinas_json, estado, lat, lon",
        "from parque_maquina",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rubro", property="rubro", jdbcType=JdbcType.VARCHAR),
        @Result(column="usuario_id", property="usuarioId", jdbcType=JdbcType.INTEGER),
        @Result(column="maquinas_json", property="maquinasJson", jdbcType=JdbcType.VARCHAR),
        @Result(column="estado", property="estado", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.REAL),
        @Result(column="lon", property="lon", jdbcType=JdbcType.REAL)
    })
    ParqueMaquina selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @UpdateProvider(type=ParqueMaquinaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParqueMaquina record, @Param("example") ParqueMaquinaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @UpdateProvider(type=ParqueMaquinaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParqueMaquina record, @Param("example") ParqueMaquinaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @UpdateProvider(type=ParqueMaquinaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParqueMaquina record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parque_maquina
     *
     * @mbggenerated Fri Aug 05 00:39:48 ART 2016
     */
    @Update({
        "update parque_maquina",
        "set rubro = #{rubro,jdbcType=VARCHAR},",
          "usuario_id = #{usuarioId,jdbcType=INTEGER},",
          "maquinas_json = #{maquinasJson,jdbcType=VARCHAR},",
          "estado = #{estado,jdbcType=VARCHAR},",
          "lat = #{lat,jdbcType=REAL},",
          "lon = #{lon,jdbcType=REAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ParqueMaquina record);
}