package com.weixin.app.orm.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;


public class CollectionUtils {
	private CollectionUtils() {
	}


	@SuppressWarnings("unchecked")
	public static List collectAsList(Collection collection, String propertyName) throws Exception {

		List list = new ArrayList();

		for (Object obj : collection) {
			list.add(PropertyUtils.getProperty(obj, propertyName));
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public static String collectAsString(Collection collection, String propertyName, String separator) throws Exception {
		List list = collectAsList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	public static <T, ID> void retainById(Collection<T> collection, Collection<ID> retainIds, Class<T> clazz)
			throws Exception {
		retainById(collection, retainIds, "id", clazz);
	}

	public static <T, ID> void retainById(Collection<T> collection, Collection<ID> retainIds, String idName,
			Class<T> clazz) throws Exception {

		if (retainIds == null) {
			collection.clear();
			return;
		}

		Iterator<T> it = collection.iterator();

		while (it.hasNext()) {
			T obj = it.next();
			if (retainIds.contains(PropertyUtils.getProperty(obj, idName))) {
				retainIds.remove(PropertyUtils.getProperty(obj, idName));
			} else {
				it.remove();
			}
		}

		for (ID id : retainIds) {
			T obj = clazz.newInstance();
			PropertyUtils.setProperty(obj, idName, id);
			collection.add(obj);
		}
	}
}
