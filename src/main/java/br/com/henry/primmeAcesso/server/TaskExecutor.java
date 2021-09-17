package br.com.henry.primmeAcesso.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
	private final ExecutorService executor;

	public TaskExecutor() {
		this.executor = Executors.newSingleThreadExecutor();
	}

	public TaskExecutor(int nThreads) {
		this.executor = Executors.newFixedThreadPool(nThreads);
	}

	public void desativar() {
		executor.shutdown();
	}
}
