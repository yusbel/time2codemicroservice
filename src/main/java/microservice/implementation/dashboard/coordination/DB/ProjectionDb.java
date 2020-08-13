package microservice.implementation.dashboard.coordination.DB;

import microservice.implementation.dashboard.coordination.projections.SequentialProjection;
import java.util.ArrayList;
import java.util.List;

public class ProjectionDb {

    final List<SequentialProjection> projections = new ArrayList();

    public void add(SequentialProjection summaryView){
        synchronized (projections){
            projections.add(summaryView);
        }
    }

    public Iterable<SequentialProjection> getAll(){
        return projections;
    }

    private static ProjectionDb singleton;
    public synchronized static ProjectionDb getSingleton(){
        if(null == singleton)
            singleton = new ProjectionDb();
        return singleton;
    }
}
