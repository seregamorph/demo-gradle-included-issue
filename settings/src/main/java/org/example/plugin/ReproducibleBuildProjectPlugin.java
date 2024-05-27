package org.example.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.AbstractArchiveTask;

/**
 * https://docs.gradle.org/current/userguide/working_with_files.html#sec:reproducible_archives
 */
public class ReproducibleBuildProjectPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks()
                .withType(AbstractArchiveTask.class)
                .configureEach(task -> {
                    task.setPreserveFileTimestamps(false);
                    task.setReproducibleFileOrder(true);
                });
    }
}
