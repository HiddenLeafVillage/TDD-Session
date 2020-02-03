package edu.timetracker.test.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LifeCycleExtensions implements BeforeAllCallback, AfterAllCallback, AfterEachCallback, BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("beforeEach callback");
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		System.out.println("afterEach callback");

	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		System.out.println("afterAll callback");

	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("beforeAll callback");

	}

}
