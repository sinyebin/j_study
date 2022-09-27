package org.comstudy21.myapp.controller;

import java.util.HashMap;

import org.comstudy21.myapp.bbs.BoardController;
import org.comstudy21.myapp.blog.BlogController;
import org.comstudy21.myapp.user.UserController;

public class HandlerMapping {
   HashMap<String, Controller> map = new HashMap();
   
   public HandlerMapping() {
      map.put("/bbs", new BoardController());
      map.put("/user", new UserController());
      map.put("/blog", new BlogController());
   }
   
   public Controller getController(String path) {
      return map.get(path);
   }
}