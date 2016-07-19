package com.hrs.mybatis.test.domain;

import java.util.Date;

public class XjStudentPo implements java.io.Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
		private Long id;
		/** 学生编号 */
		private String stuSequence;
		/** 学号 */
		private String stuNo;
		/** 学生姓名 */
		private String name;
		/** 性别 */
		private Long sex;
		/** 出生年月 */
		private Date birthday;
		/** 家庭地址 */
		private String address;
		/** 籍贯 */
		private String origin;
		/** 民族 */
		private Long nation;
		/** 户口所在地 */
		private String originAddr;
		/** 血型 */
		private Long bloodType;
		/** 政治面貌 */
		private Long politics;
		/** IC卡号 */
		private String icNo;
		/** 家庭电话 */
		private String homePhone;
		/** 特长 */
		private String goodAt;
		/** 身份证号 */
		private String identyNo;
		/** 出生地 */
		private String bornAddress;
		/** 健康状况 */
		private String health;
		/** IC卡状态 */
		private Long icStatus;
		/** 入校时间 */
		private Date inSchoolDate;
		/** 住宿情况 0走读 1住读 2非长住 */
		private Integer stuType;
		/** 座位号 */
		private Long seatNumber;
		/** IC卡号 */
		private String cardNo;
		/** 家长头像 */
		private String headImage;
		/** QQ */
		private String qq;
		/** 邮箱 */
		private String email;
		/** 来源xj_class_join的id */
		private Long xjClassJoinId;
		/** 备注 */
		private String remark;

		public String getIcNo() {
			return icNo;
		}

		public void setIcNo(String icNo) {
			this.icNo = icNo;
		}

		public String getStuSequence() {
			return stuSequence;
		}

		public void setStuSequence(String stuSequence) {
			this.stuSequence = stuSequence;
		}

		public String getStuNo() {
			return stuNo;
		}

		public void setStuNo(String stuNo) {
			this.stuNo = stuNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getSex() {
			return sex;
		}

		public void setSex(Long sex) {
			this.sex = sex;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getOrigin() {
			return origin;
		}

		public void setOrigin(String origin) {
			this.origin = origin;
		}

		public Long getNation() {
			return nation;
		}

		public void setNation(Long nation) {
			this.nation = nation;
		}

		public String getOriginAddr() {
			return originAddr;
		}

		public void setOriginAddr(String originAddr) {
			this.originAddr = originAddr;
		}

		public Long getBloodType() {
			return bloodType;
		}

		public void setBloodType(Long bloodType) {
			this.bloodType = bloodType;
		}

		public Long getPolitics() {
			return politics;
		}

		public void setPolitics(Long politics) {
			this.politics = politics;
		}

		public String getHomePhone() {
			return homePhone;
		}

		public void setHomePhone(String homePhone) {
			this.homePhone = homePhone;
		}

		public String getGoodAt() {
			return goodAt;
		}

		public void setGoodAt(String goodAt) {
			this.goodAt = goodAt;
		}

		public String getIdentyNo() {
			return identyNo;
		}

		public void setIdentyNo(String identyNo) {
			this.identyNo = identyNo;
		}

		public String getBornAddress() {
			return bornAddress;
		}

		public void setBornAddress(String bornAddress) {
			this.bornAddress = bornAddress;
		}

		public String getHealth() {
			return health;
		}

		public void setHealth(String health) {
			this.health = health;
		}

		public Long getIcStatus() {
			return icStatus;
		}

		public void setIcStatus(Long icStatus) {
			this.icStatus = icStatus;
		}

		public Date getInSchoolDate() {
			return inSchoolDate;
		}

		public void setInSchoolDate(Date inSchoolDate) {
			this.inSchoolDate = inSchoolDate;
		}

		public Integer getStuType() {
			return stuType;
		}

		public void setStuType(Integer stuType) {
			this.stuType = stuType;
		}

		public Long getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(Long seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getHeadImage() {
			return headImage;
		}

		public void setHeadImage(String headImage) {
			this.headImage = headImage;
		}

		public String getQq() {
			return qq;
		}

		public void setQq(String qq) {
			this.qq = qq;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getXjClassJoinId() {
			return xjClassJoinId;
		}

		public void setXjClassJoinId(Long xjClassJoinId) {
			this.xjClassJoinId = xjClassJoinId;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		

		

}
