package com.lagou.domain;

public class CourseVO {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    /**
     * 课程名称
     * */
    private String courseName;

    /**
     * 课程状态
     * */
    private Integer status;

    /**
     * 课程ID
     * */
    private Integer id;

    /**
     * 课程一句话简介
     */
    private String brief;

    /**
     * 讲师姓名
     * */
    private String teacherName;

    /**
     * 职位
     * */
    private String position;

    /**
     * 讲师简介
     * */
    private String description;

    /**
     * 课程概述第一个字段
     * */
    private String previewFirstField;

    /**
     * 课程概述第二个字段
     * */
    private String previewSecondField;

    /**
     * 课程图片url
     * */
    private String courseImgUrl;

    /**
     * 课程封面图
     * */
    private String courseListImg;

    /**
     * 课程排序
     * */
    private int sortNum;

    /**
     * 商品原价
     * */
    private double price;

    /**
     * 售卖价格
     * */
    private double discounts;


    /**
     * 销量
     * */
    private int sales;

    /**
     * 活动标签
     * */
    private String discountsTag;

    /**
     * 课程详情
     * */
    private String courseDescriptionMarkDown;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewFirstField() {
        return previewFirstField;
    }

    public void setPreviewFirstField(String previewFirstField) {
        this.previewFirstField = previewFirstField;
    }

    public String getPreviewSecondField() {
        return previewSecondField;
    }

    public void setPreviewSecondField(String previewSecondField) {
        this.previewSecondField = previewSecondField;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getCourseListImg() {
        return courseListImg;
    }

    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getDiscountsTag() {
        return discountsTag;
    }

    public void setDiscountsTag(String discountsTag) {
        this.discountsTag = discountsTag;
    }

    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }
}
