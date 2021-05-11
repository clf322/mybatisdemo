package com.example.mybatisdemo.entity;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 23:15 2021/5/9
 * @Modified By:
 */

import java.io.Serializable;
import java.util.Date;

/**
 *ClassName mybatisdemo
 *@Description TODO
 *@Author: longfei
 *@Date: 2021/5/9 23:15
 *@Version 1.0
 **/
public class runoobTbl implements Serializable{
  private Integer runoobId;
  private String runoobTitle;
  private String runoobAuthor;
  private Date submissionDate;

    public Integer getRunoobId() {
        return runoobId;
    }

    public void setRunoobId(Integer runoobId) {
        this.runoobId = runoobId;
    }

    public String getRunoobTitle() {
        return runoobTitle;
    }

    public void setRunoobTitle(String runoobTitle) {
        this.runoobTitle = runoobTitle;
    }

    public String getRunoobAuthor() {
        return runoobAuthor;
    }

    public void setRunoobAuthor(String runoobAuthor) {
        this.runoobAuthor = runoobAuthor;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "mybatisdemo{" +
                "runoobId=" + runoobId +
                ", runoobTitle='" + runoobTitle + '\'' +
                ", runoobAuthor='" + runoobAuthor + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
