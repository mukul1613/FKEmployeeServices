/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mukul.kumar
 */
public final class FlipNews {
     List<String> news;
 
  public FlipNews(){
      this.news = new LinkedList<>();
      updateNews("test data");
  }

    public List<String> getNews() {
        return news;
    }
    

    public void updateNews(String data) {
        this.news.add("this is sample news 1"+data);
        this.news.add("this is sample news 2");
        this.news.add("this is sample news 3");
     }

    public void setNews(List<String> news) {
        this.news = news;
    }
    
}
