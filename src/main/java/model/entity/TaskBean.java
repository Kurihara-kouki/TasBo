package model.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class TaskBean implements Serializable {
	//idは表示こそないもののデータの動きの都合上必要になる（チェックボックス関連）
	private int taskId;
	private String taskName;
	private int categoryId;
	private LocalDate limitDate;
	private String userId;
	private String statusCode;
	private String memo;
	//いらないかもしれない。これでよいのか、週明け要相談。
	private LocalDate createDatetime;
	private LocalDate UpdateDatetime;
	
	//カテゴリ名、担当者名、ステータス名の追加
	private String categoryName;
	private String userName;
	private String statusName;
	
	public TaskBean() {
		
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public LocalDate getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public LocalDate getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(LocalDate createDatetime) {
		this.createDatetime = createDatetime;
	}
	public LocalDate getUpdateDatetime() {
		return UpdateDatetime;
	}
	public void setUpdateDatetime(LocalDate updateDatetime) {
		UpdateDatetime = updateDatetime;
	}
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}

