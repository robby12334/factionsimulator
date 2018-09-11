package com.factionsimulator.fs;

import com.factionsimulator.fs.ui.view.MainPage;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
@PreserveOnRefresh
@Theme("valo")
public class FactionSimulator extends UI {
	private static final long serialVersionUID = -1300556702704779780L;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		// setupLayout();
		// addHeader();
		// addForm();
		// addActionButtons();
		getPage().setTitle("Faction Simulator");

		showView();

	}

	protected void showView() {
		setContent(new MainPage());
	}
}
