package coincap;

import java.util.List;

public class BaseClasses {

    static class JsonFormat {
        public List<Assets> data;
        public long timestamp;
    }

    static class Assets {
        public String id;
        public int rank;
        public String symbol;
        public String name;
        public double supply;
        public double maxSupply;
        public double marketCapUsd;
        public double volumeUsd24Hr;
        public double priceUsd;
        public double changePercent24Hr;
        public double vwap24Hr;
        public String explorer;
    }
}
