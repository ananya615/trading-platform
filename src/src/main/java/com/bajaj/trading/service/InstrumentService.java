package com.bajaj.trading.service;

import com.bajaj.trading.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    public List<Instrument> getAll() {
        Instrument tcs = new Instrument();
        tcs.symbol = "TCS";
        tcs.exchange = "NSE";
        tcs.instrumentType = "EQ";
        tcs.lastTradedPrice = 3650.50;
        return List.of(tcs);
    }
}
