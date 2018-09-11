package com.factionsimulator.fs.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class HomeView extends CssLayout implements View {

	private static final long serialVersionUID = 2084349410994891009L;

	HorizontalLayout chartLayout = null;

	public HomeView() {
		buildLayout();
	}

	private void buildLayout() {
	}

	@Override
	public void enter(ViewChangeEvent event) {
		setSizeFull();
		chartLayout = new HorizontalLayout();
		chartLayout.setSizeFull();
		addComponent(chartLayout);
	}

}
