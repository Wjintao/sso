package com.alexgaoyh.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.alexgaoyh.common.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	/**
	 * 保存/更新
	 * @param entity
	 * @throws ValidateException 
	 */
	void saveOrUpdate(E entity) throws Exception;
	
	/**
	 * 根据对应列获取全部实体信息，排序
	 * @param orderBy 排序字段
	 * @return
	 */
	List<E> getAll(String orderBy);
	
	/**
	 * 获取全部实体信息
	 * @return
	 */
	List<E> getAll();
	
	/**
	 * 查询数据
	 * @param hql
	 * @param parameters
	 * @return
	 */
	E queryForObject(String hql, Object[] parameters);
	
	/**
	 * 根据主键pid 获取对应实体信息
	 * @param pid
	 * @return
	 */
	E get(Integer pid);
	
	void evict(Object entity);

	/**
	 * 根据入参参数类型获取到复合条件的所有实体信息条数
	 * @param condition
	 * @return
	 */
	int getRowCountByDetachedCriteria(DetachedCriteria condition);

	/**
	 * 根据入参参数类型获取到复合条件的所有实体信息list集合
	 * @param condition
	 * @param page
	 * @param rows
	 * @return
	 */
	List<E> findByDetachedCriteria(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 实体保存
	 * @param entity
	 * @throws Exception
	 */
	void save(E entity) throws Exception;
	
	/**
	 * 实体更新
	 * @param entity
	 * @throws Exception
	 */
	void update(E entity) throws Exception;
	
	/**
	 * 逻辑删除，入参为pid主键数组
	 * @param pidArray
	 * @throws Exception
	 */
	void deleteLogicByIds(String[] pidArray) throws Exception;
}
