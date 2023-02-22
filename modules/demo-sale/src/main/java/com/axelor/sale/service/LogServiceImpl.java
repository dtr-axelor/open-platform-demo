package com.axelor.sale.service;

import com.axelor.event.Observes;
import com.axelor.events.ShutdownEvent;
import com.axelor.sale.db.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogServiceImpl implements LogService {

  StringBuilder msgBld = new StringBuilder();

  @Override
  public void logOrderTotal(Order order) {

    String msg =
        String.format(
            "The total ammount of the order %d is %d.", order.getId(), order.getTotalAmount());
    msgBld.append(msg);
    msgBld.append("\n");
  }

  @Override
  public void writeToFile(@Observes ShutdownEvent event) throws IOException {

    FileWriter fileWriter = new FileWriter("logs/app.log");
    PrintWriter printWriter = new PrintWriter(fileWriter);
    printWriter.print(msgBld.toString());
    printWriter.close();
  }
}
