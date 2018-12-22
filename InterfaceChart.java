package RepoG5;

import org.knowm.xchart.internal.chartpart.Chart;

public interface InterfaceChart<C extends Chart<?, ?>> {
    C getChart();
}