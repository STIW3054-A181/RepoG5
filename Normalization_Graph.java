package RepoG5;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler.ChartTheme;
import static RepoG5.Zscore.callZscore;

public class Normalization_Graph implements InterfaceChart<XYChart>, RealTimeChart{ // Display normalization graph (z score)
    private XYChart xyChart;

    private List<Double> yData;
    public static final String SERIES_NAME = "Z score value";

    public void go() {
        final SwingWrapper<XYChart> swingWrapper = new SwingWrapper<XYChart>(getChart());
        swingWrapper.displayChart();
        // Simulate a data feed
        TimerTask chartUpdaterTask =
                new TimerTask() {
                    @Override
                    public void run() {
                        updateData();
                        javax.swing.SwingUtilities.invokeLater(
                                new Runnable(){
                                    @Override
                                    public void run() {
                                        swingWrapper.repaintChart();
                                    }
                                });
                    }
                };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(chartUpdaterTask, 0, 1000);
    }

    @Override
    public XYChart getChart() {
        yData = applyZscore();
        // Create Chart
        xyChart =
                new XYChartBuilder()
                        .width(500)
                        .height(400)
                        .theme(ChartTheme.Matlab)
                        .title("Normalization Graph")
                        .build();
        xyChart.addSeries(SERIES_NAME, null, yData);

        return xyChart;
    }

    public void updateData() {
        // Get new z score value
        List<Double> nextData = applyZscore();
        yData.addAll(nextData);

        while (yData.size() > 26) {
            yData.remove(0);
        }
        xyChart.updateXYSeries(SERIES_NAME, null, yData, null);
    }

    private List<Double> applyZscore() {
        List<Double> zScore = new CopyOnWriteArrayList<Double>();
        try {
            for (ZscoreValue value : callZscore()) {
                zScore.add(value.getzScore());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return zScore;
    }
}
