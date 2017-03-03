package com.testnotepad;

import junit.framework.Assert;

import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings("unchecked")
public class TestApk extends ActivityInstrumentationTestCase2 {
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.example.android.notepad.NotesList";
	private static Class launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public TestApk() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testPreferenceIsSaved() throws Exception {

		solo.sendKey(Solo.MENU);
		solo.clickOnMenuItem("Add note");

	}

	// Tap on Multiply button solo.clickOnButton("Multiply");
	// Assert that the correct resultant of 10 x 20 is returned
	// assertTrue("Problem asserting multiply", solo.searchText("200"));
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}