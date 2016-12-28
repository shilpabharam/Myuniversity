package com.codecoop.myuniversity.core.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecoop.myuniversity.core.dao.PathFinderDao;
import com.codecoop.myuniversity.core.domain.PathFinder;
import com.codecoop.myuniversity.core.dto.AllPathFinderDto;
import com.codecoop.myuniversity.core.dto.PathFinderDto;

@Service
public class PathFinderService {

	@Autowired
	PathFinderDao resourceDao;

	/*
	 * Creation of path finder.
	 */
	@Transactional
	public String createResource(PathFinderDto reourceDto) {
		String status = "";
		PathFinder resource = new PathFinder();

		try {
			resource.setTitle(reourceDto.getTitle());
			resource.setNotes(reourceDto.getNotes());
			resource.setCreatedDate(new Date());
			resourceDao.save(resource);
			status = "Resource created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while creating resource";
		}
		return status;
	}
	/*
	 * updating path finder.
	 */
	@Transactional
	public String updateResource(PathFinderDto resourceDto) {
		String status = "";

		try {
			PathFinder resource = resourceDao.getResources(resourceDto.getId());
			resource.setNotes(resourceDto.getNotes());
			resourceDao.saveOrUpdate(resource);
			status = "Resource updated successfully";
		} catch (Exception e) {
			status = "Error while updating resource";
		}
		return status;

	}
	/*
	 * Deleting path finder.
	 */
	@Transactional
	public String deleteResource(Long id) {
		String status = "";

		try {
			PathFinder resource = resourceDao.getResources(id);

			if (resource == null) {
				status = "Resource does not exist";
			} else {
				resourceDao.delete(resource);
				status = "Resource deleted successfully";
			}
		} catch (Exception e) {
			status = "Error while deleting resource";
		}
		return status;

	}

	/*
	 * Getting path finder.
	 */
	@Transactional
	public PathFinderDto getResource(Long id) throws IllegalAccessException,
			InvocationTargetException {
		PathFinderDto resourceDto = new PathFinderDto();
		PathFinder resource = resourceDao.getResources(id);

		if (resource != null) {
			resourceDto.setId(resource.getId());
			resourceDto.setTitle(resource.getTitle());
			resourceDto.setNotes(resource.getNotes());
			resourceDto.setCreatedDate(resource.getCreatedDate());

		}
		return resourceDto;
	}
	/*
	 * getting all path finder.
	 */
	@Transactional
	public AllPathFinderDto getAllResource(Integer start, Integer limit)
			throws IllegalAccessException, InvocationTargetException {
		AllPathFinderDto allResources = new AllPathFinderDto();

		List<PathFinder> resources = resourceDao.getAllResources((start - 1)
				* limit, limit);
		List<PathFinderDto> resourcesDto = new ArrayList<PathFinderDto>();

		for (PathFinder resource : resources) {
			PathFinderDto resourceDto = new PathFinderDto();
			BeanUtils.copyProperties(resourceDto, resource);

			resourcesDto.add(resourceDto);
		}

		allResources.setPageNumber(start);
		allResources.setTotalRecords(resourceDao.getAllResourcesCount());
		allResources.setResources(resourcesDto);

		return allResources;
	}

}
