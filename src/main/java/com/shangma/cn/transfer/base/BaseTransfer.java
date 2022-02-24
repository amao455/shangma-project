package com.shangma.cn.transfer.base;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class BaseTransfer<DTO,Entity> {

    /*
    * entity转DTO
    * */
    public DTO toDTO(Entity entity){
        try{
            Class<DTO> entityClass = (Class<DTO>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            DTO o = entityClass.newInstance();
            BeanUtils.copyProperties(entity, o);
            return o;
        } catch(Exception e){
            return null;
        }
    }

    /*
     * DTO转entity
     * */
    public Entity toEntity(DTO dto){
        try{
            Class<Entity> entityClass = (Class<Entity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            Entity entity = entityClass.newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        }catch(Exception e){
            return null;
        }
    }

    /*
    *
    * */
    public List<DTO> toDTO(List<Entity> list){
        List<DTO> dtos = new ArrayList<>();
        list.forEach(entity -> dtos.add(toDTO(entity)));
        return dtos;
    }


    public List<Entity> toEntity(List<DTO> list){
        List<Entity> entities = new ArrayList<>();
        list.forEach(dto -> entities.add(toEntity(dto)));
        return entities;
    }



}
