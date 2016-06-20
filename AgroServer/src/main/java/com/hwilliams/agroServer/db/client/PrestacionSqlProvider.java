package com.hwilliams.agroServer.db.client;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.hwilliams.agroServer.db.model.Prestacion;
import com.hwilliams.agroServer.db.model.PrestacionExample.Criteria;
import com.hwilliams.agroServer.db.model.PrestacionExample.Criterion;
import com.hwilliams.agroServer.db.model.PrestacionExample;
import java.util.List;
import java.util.Map;

public class PrestacionSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String countByExample(PrestacionExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("prestacion");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String deleteByExample(PrestacionExample example) {
        BEGIN();
        DELETE_FROM("prestacion");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String insertSelective(Prestacion record) {
        BEGIN();
        INSERT_INTO("prestacion");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPropietarioId() != null) {
            VALUES("propietario_id", "#{propietarioId,jdbcType=INTEGER}");
        }
        
        if (record.getMaquinaId() != null) {
            VALUES("maquina_id", "#{maquinaId,jdbcType=INTEGER}");
        }
        
        if (record.getFechaDesde() != null) {
            VALUES("fecha_desde", "#{fechaDesde,jdbcType=DATE}");
        }
        
        if (record.getFechaHasta() != null) {
            VALUES("fecha_hasta", "#{fechaHasta,jdbcType=DATE}");
        }
        
        if (record.getClienteId() != null) {
            VALUES("cliente_id", "#{clienteId,jdbcType=INTEGER}");
        }
        
        if (record.getEstado() != null) {
            VALUES("estado", "#{estado,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String selectByExample(PrestacionExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("propietario_id");
        SELECT("maquina_id");
        SELECT("fecha_desde");
        SELECT("fecha_hasta");
        SELECT("cliente_id");
        SELECT("estado");
        FROM("prestacion");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Prestacion record = (Prestacion) parameter.get("record");
        PrestacionExample example = (PrestacionExample) parameter.get("example");
        
        BEGIN();
        UPDATE("prestacion");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPropietarioId() != null) {
            SET("propietario_id = #{record.propietarioId,jdbcType=INTEGER}");
        }
        
        if (record.getMaquinaId() != null) {
            SET("maquina_id = #{record.maquinaId,jdbcType=INTEGER}");
        }
        
        if (record.getFechaDesde() != null) {
            SET("fecha_desde = #{record.fechaDesde,jdbcType=DATE}");
        }
        
        if (record.getFechaHasta() != null) {
            SET("fecha_hasta = #{record.fechaHasta,jdbcType=DATE}");
        }
        
        if (record.getClienteId() != null) {
            SET("cliente_id = #{record.clienteId,jdbcType=INTEGER}");
        }
        
        if (record.getEstado() != null) {
            SET("estado = #{record.estado,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("prestacion");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("propietario_id = #{record.propietarioId,jdbcType=INTEGER}");
        SET("maquina_id = #{record.maquinaId,jdbcType=INTEGER}");
        SET("fecha_desde = #{record.fechaDesde,jdbcType=DATE}");
        SET("fecha_hasta = #{record.fechaHasta,jdbcType=DATE}");
        SET("cliente_id = #{record.clienteId,jdbcType=INTEGER}");
        SET("estado = #{record.estado,jdbcType=VARCHAR}");
        
        PrestacionExample example = (PrestacionExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String updateByPrimaryKeySelective(Prestacion record) {
        BEGIN();
        UPDATE("prestacion");
        
        if (record.getPropietarioId() != null) {
            SET("propietario_id = #{propietarioId,jdbcType=INTEGER}");
        }
        
        if (record.getMaquinaId() != null) {
            SET("maquina_id = #{maquinaId,jdbcType=INTEGER}");
        }
        
        if (record.getFechaDesde() != null) {
            SET("fecha_desde = #{fechaDesde,jdbcType=DATE}");
        }
        
        if (record.getFechaHasta() != null) {
            SET("fecha_hasta = #{fechaHasta,jdbcType=DATE}");
        }
        
        if (record.getClienteId() != null) {
            SET("cliente_id = #{clienteId,jdbcType=INTEGER}");
        }
        
        if (record.getEstado() != null) {
            SET("estado = #{estado,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prestacion
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected void applyWhere(PrestacionExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}