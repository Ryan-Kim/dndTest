/*
 * Copyright 2009 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package lalala.client.demo;

import com.google.gwt.user.client.ui.*;

import com.allen_sauer.gwt.dnd.client.DragController;

import java.util.ArrayList;

/**
 * Example of two lists side by side for {@link DualListExample}.
 */
public class RoomsView extends AbsolutePanel {

  private static final String CSS_DEMO_DUAL_LIST_EXAMPLE_CENTER = "demo-DualListExample-center";

  private static final int LIST_SIZE = 10;

  private ListBoxDragController dragController;

  private MouseListBox waitingList;

  private MouseListBox room1;
  private MouseListBox room2;
    private MouseListBox room3;
    private MouseListBox room4;

  public RoomsView(int visibleItems, String width) {
    HorizontalPanel firstRow = new HorizontalPanel();
    HorizontalPanel secondRow = new HorizontalPanel();
    add(firstRow);
    add(secondRow);
    firstRow.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
    secondRow.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);


      VerticalPanel verticalPadding200 = new VerticalPanel();
      verticalPadding200.addStyleName("width200");
      verticalPadding200.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

    VerticalPanel verticalPadding = new VerticalPanel();
    verticalPadding.addStyleName(CSS_DEMO_DUAL_LIST_EXAMPLE_CENTER);
    verticalPadding.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

      VerticalPanel verticalPadding2 = new VerticalPanel();
      verticalPadding.addStyleName(CSS_DEMO_DUAL_LIST_EXAMPLE_CENTER);
      verticalPadding.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);



    dragController = new ListBoxDragController(this);
    waitingList = new MouseListBox(dragController,LIST_SIZE);
    room1 = new MouseListBox(dragController, LIST_SIZE);
    room2 = new MouseListBox(dragController, LIST_SIZE);

    VerticalPanel waitingRoomPanel = new VerticalPanel();
    waitingRoomPanel.add(new Label("waiting room"));
    waitingRoomPanel.add(waitingList);

    VerticalPanel room1Panel = new VerticalPanel();
      room1Panel.add(new Label("room 1"));
      room1Panel.add(room1);

      VerticalPanel room2Panel = new VerticalPanel();
      room2Panel.add(new Label("room 2"));
      room2Panel.add(room2);

    waitingList.setWidth(width);
    room1.setWidth(width);
    room2.setWidth(width);


    firstRow.add(waitingRoomPanel);
    firstRow.add(verticalPadding200);
    firstRow.add(room1Panel);
    firstRow.add(verticalPadding);
    firstRow.add(room2Panel);

    //
      room3 = new MouseListBox(dragController, LIST_SIZE);
      room4 = new MouseListBox(dragController, LIST_SIZE);
    room3.setWidth(width);
    room4.setWidth(width);

      VerticalPanel room3Panel = new VerticalPanel();
      room1Panel.add(new Label("room 3"));
      room1Panel.add(room3);

      VerticalPanel room4Panel = new VerticalPanel();
      room1Panel.add(new Label("room 4"));
      room1Panel.add(room4);

      secondRow.add(room3Panel);
      secondRow.add(verticalPadding2);
      secondRow.add(room4Panel);



    ListBoxDropController waitingListController = new ListBoxDropController(waitingList);
    ListBoxDropController room1Controller = new ListBoxDropController(room1);
    ListBoxDropController room2Controller = new ListBoxDropController(room2);
    ListBoxDropController room3Controller = new ListBoxDropController(room3);
    ListBoxDropController room4Controller = new ListBoxDropController(room4);
    dragController.registerDropController(waitingListController);
    dragController.registerDropController(room1Controller);
    dragController.registerDropController(room2Controller);
    dragController.registerDropController(room3Controller);
    dragController.registerDropController(room4Controller);


  }

  public void addLeft(String string) {
    waitingList.add(string);
  }

  /**
   * Adds an widget to the waitingList list box.
   * 
   * @param widget the text of the item to be added
   */
  public void addLeft(Widget widget) {
    waitingList.add(widget);
  }

  public DragController getDragController() {
    return dragController;
  }

  protected void moveItems(MouseListBox from, MouseListBox to, boolean justSelectedItems) {
    ArrayList<Widget> widgetList = justSelectedItems ? dragController.getSelectedWidgets(from)
        : from.widgetList();
    for (Widget widget : widgetList) {
      // TODO let widget.removeFromParent() take care of from.remove()
      from.remove(widget);
      to.add(widget);
    }
  }
}
