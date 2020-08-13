package microservice.implementation.dashboard.coordination;

import microservice.implementation.dashboard.coordination.DB.ProjectionDb;
import microservice.implementation.dashboard.coordination.projections.SequentialProjection;

public class SequentialViewHandler {

    public static Iterable<SequentialProjection> handle(FindSequentialViewCmd cmd) {
            return ProjectionDb.getSingleton().getAll();
    }
}
