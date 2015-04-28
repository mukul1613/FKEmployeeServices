/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaNews;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mukul.kumar
 */
public final class FlipNews {

    List<String> news;

    public FlipNews() {
        this.news = new LinkedList<>();
    }

    public FlipNews(EvaNews dbEntityObj) {
        this();
        if (dbEntityObj != null) {
            this.news.add(dbEntityObj.getNews1());
            this.news.add(dbEntityObj.getNews2());
            this.news.add(dbEntityObj.getNews3());
        } else {
            updateNewsForDataNotAvailable();
        }
    }

    public List<String> getNews() {
        return news;
    }

    public void updateNewsForDataNotAvailable() {
        this.news.add("news not available");
        this.news.add("news not available");
        this.news.add("news not available");
    }

    public void setNews(List<String> news) {
        this.news = news;
    }

}
