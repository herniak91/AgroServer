package com.hwilliams.agroServer.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OfertaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public OfertaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUsuarioIdIsNull() {
            addCriterion("usuario_id is null");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdIsNotNull() {
            addCriterion("usuario_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdEqualTo(Integer value) {
            addCriterion("usuario_id =", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdNotEqualTo(Integer value) {
            addCriterion("usuario_id <>", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdGreaterThan(Integer value) {
            addCriterion("usuario_id >", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("usuario_id >=", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdLessThan(Integer value) {
            addCriterion("usuario_id <", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdLessThanOrEqualTo(Integer value) {
            addCriterion("usuario_id <=", value, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdIn(List<Integer> values) {
            addCriterion("usuario_id in", values, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdNotIn(List<Integer> values) {
            addCriterion("usuario_id not in", values, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdBetween(Integer value1, Integer value2) {
            addCriterion("usuario_id between", value1, value2, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andUsuarioIdNotBetween(Integer value1, Integer value2) {
            addCriterion("usuario_id not between", value1, value2, "usuarioId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdIsNull() {
            addCriterion("maquina_id is null");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdIsNotNull() {
            addCriterion("maquina_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdEqualTo(Integer value) {
            addCriterion("maquina_id =", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdNotEqualTo(Integer value) {
            addCriterion("maquina_id <>", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdGreaterThan(Integer value) {
            addCriterion("maquina_id >", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maquina_id >=", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdLessThan(Integer value) {
            addCriterion("maquina_id <", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdLessThanOrEqualTo(Integer value) {
            addCriterion("maquina_id <=", value, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdIn(List<Integer> values) {
            addCriterion("maquina_id in", values, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdNotIn(List<Integer> values) {
            addCriterion("maquina_id not in", values, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdBetween(Integer value1, Integer value2) {
            addCriterion("maquina_id between", value1, value2, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andMaquinaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("maquina_id not between", value1, value2, "maquinaId");
            return (Criteria) this;
        }

        public Criteria andLatitudIsNull() {
            addCriterion("latitud is null");
            return (Criteria) this;
        }

        public Criteria andLatitudIsNotNull() {
            addCriterion("latitud is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudEqualTo(Float value) {
            addCriterion("latitud =", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotEqualTo(Float value) {
            addCriterion("latitud <>", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudGreaterThan(Float value) {
            addCriterion("latitud >", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudGreaterThanOrEqualTo(Float value) {
            addCriterion("latitud >=", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudLessThan(Float value) {
            addCriterion("latitud <", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudLessThanOrEqualTo(Float value) {
            addCriterion("latitud <=", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudIn(List<Float> values) {
            addCriterion("latitud in", values, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotIn(List<Float> values) {
            addCriterion("latitud not in", values, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudBetween(Float value1, Float value2) {
            addCriterion("latitud between", value1, value2, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotBetween(Float value1, Float value2) {
            addCriterion("latitud not between", value1, value2, "latitud");
            return (Criteria) this;
        }

        public Criteria andLongitudIsNull() {
            addCriterion("longitud is null");
            return (Criteria) this;
        }

        public Criteria andLongitudIsNotNull() {
            addCriterion("longitud is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudEqualTo(Float value) {
            addCriterion("longitud =", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudNotEqualTo(Float value) {
            addCriterion("longitud <>", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudGreaterThan(Float value) {
            addCriterion("longitud >", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudGreaterThanOrEqualTo(Float value) {
            addCriterion("longitud >=", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudLessThan(Float value) {
            addCriterion("longitud <", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudLessThanOrEqualTo(Float value) {
            addCriterion("longitud <=", value, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudIn(List<Float> values) {
            addCriterion("longitud in", values, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudNotIn(List<Float> values) {
            addCriterion("longitud not in", values, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudBetween(Float value1, Float value2) {
            addCriterion("longitud between", value1, value2, "longitud");
            return (Criteria) this;
        }

        public Criteria andLongitudNotBetween(Float value1, Float value2) {
            addCriterion("longitud not between", value1, value2, "longitud");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeIsNull() {
            addCriterion("disponibilidad_desde is null");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeIsNotNull() {
            addCriterion("disponibilidad_desde is not null");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde =", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeNotEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde <>", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeGreaterThan(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde >", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde >=", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeLessThan(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde <", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_desde <=", value, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeIn(List<Date> values) {
            addCriterionForJDBCDate("disponibilidad_desde in", values, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeNotIn(List<Date> values) {
            addCriterionForJDBCDate("disponibilidad_desde not in", values, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disponibilidad_desde between", value1, value2, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadDesdeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disponibilidad_desde not between", value1, value2, "disponibilidadDesde");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaIsNull() {
            addCriterion("disponibilidad_hasta is null");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaIsNotNull() {
            addCriterion("disponibilidad_hasta is not null");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta =", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaNotEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta <>", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaGreaterThan(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta >", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta >=", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaLessThan(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta <", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disponibilidad_hasta <=", value, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaIn(List<Date> values) {
            addCriterionForJDBCDate("disponibilidad_hasta in", values, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaNotIn(List<Date> values) {
            addCriterionForJDBCDate("disponibilidad_hasta not in", values, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disponibilidad_hasta between", value1, value2, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andDisponibilidadHastaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disponibilidad_hasta not between", value1, value2, "disponibilidadHasta");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNull() {
            addCriterion("estado is null");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNotNull() {
            addCriterion("estado is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoEqualTo(String value) {
            addCriterion("estado =", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotEqualTo(String value) {
            addCriterion("estado <>", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThan(String value) {
            addCriterion("estado >", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThanOrEqualTo(String value) {
            addCriterion("estado >=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThan(String value) {
            addCriterion("estado <", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThanOrEqualTo(String value) {
            addCriterion("estado <=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLike(String value) {
            addCriterion("estado like", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotLike(String value) {
            addCriterion("estado not like", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoIn(List<String> values) {
            addCriterion("estado in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotIn(List<String> values) {
            addCriterion("estado not in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoBetween(String value1, String value2) {
            addCriterion("estado between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotBetween(String value1, String value2) {
            addCriterion("estado not between", value1, value2, "estado");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table oferta
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 19 15:33:44 ART 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table oferta
     *
     * @mbggenerated Sun Jun 19 15:33:44 ART 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}