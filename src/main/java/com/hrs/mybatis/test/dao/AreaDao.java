package com.hrs.mybatis.test.dao;

import org.apache.ibatis.annotations.Param;

import com.hrs.mybatis.test.domain.Area;
import com.hrs.mybatis.test.domain.XjStudentPo;

public interface AreaDao  {
	
	Area findAreaByIdAndAbb(@Param("abb") String abb,@Param("id") Long id);
	
	XjStudentPo findStudentByStuSequence(@Param("abb") String abb, @Param("stuSequence") String stuSequence);
}
