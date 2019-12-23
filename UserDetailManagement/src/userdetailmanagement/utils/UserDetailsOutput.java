package userdetailmanagement.utils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import userdetailmanagement.models.UserDetails;

public class UserDetailsOutput {
  Logger logger = Logger.getLogger(UserDetailsOutput.class.getName());

  public void displayUser(List<UserDetails> usersList) {
    logger.log(Level.INFO,"-----------------------------------------------------------------------------------------");
    String head = String.format("%1$-15s %2$-15s %3$-15s %4$-20s %5$-10s", "Name", "Roll Number", "Age", "Address", "Courses");
    logger.log(Level.INFO,head);
    logger.log(Level.INFO,"-----------------------------------------------------------------------------------------");
    usersList.forEach(x->logger.log(Level.INFO,x.toString()));
    logger.log(Level.INFO,"");
  }
}
