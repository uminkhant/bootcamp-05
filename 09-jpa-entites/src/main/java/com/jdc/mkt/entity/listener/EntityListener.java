package com.jdc.mkt.entity.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


public class EntityListener {

	@PrePersist
	void afterPersist(Object obj) {

		if (obj instanceof ObjectEnableListener entity) {
			var times = entity.getTimes();

			if (null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateDate(LocalDateTime.now());

			System.out.println("after create date :" + LocalDateTime.now());
		}
	}

	@PreUpdate
	void afterUpdate(Object obj) {

		if (obj instanceof ObjectEnableListener entity) {

			var times = entity.getTimes();

			if (null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateDate(LocalDateTime.now());
			System.out.println("after update date :" + LocalDateTime.now());
		}
	}

}
