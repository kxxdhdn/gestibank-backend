package com.gk.models.response;

public class MessageResponse {

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public MessageResponse(String message) {
    super();
    this.message = message;
  }

  public MessageResponse() {
    super();
  }

}
