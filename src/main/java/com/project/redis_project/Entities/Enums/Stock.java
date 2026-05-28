package com.project.redis_project.Entities.Enums;

import lombok.Getter;

@Getter
public enum Stock {
     NOT_IN_STOCK(false, "Item is currently not available"),
     IN_STOCK(true, "item ia available");

     private final boolean isAvailable;
     private final String message;

     Stock(boolean isAvailable, String message) {
          this.isAvailable = isAvailable;
          this.message = message;
     }

}
