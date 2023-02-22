package com.axelor.sale.service;

import com.axelor.events.ShutdownEvent;
import com.axelor.sale.db.Order;
import java.io.IOException;

public interface LogService {

  void logOrderTotal(Order order);

  void writeToFile(ShutdownEvent event) throws IOException;
}
