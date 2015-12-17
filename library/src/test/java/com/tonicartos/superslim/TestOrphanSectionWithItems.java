package com.tonicartos.superslim;

import com.tonicartos.superslim.adapter.Item;
import com.tonicartos.superslim.adapter.Section;
import com.tonicartos.superslim.adapter.SuperSlimAdapter;

import org.junit.Before;
import org.junit.Test;

import android.support.v7.widget.RecyclerView;

import static com.tonicartos.superslim.Util.ItemData;
import static com.tonicartos.superslim.Util.hasChildCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Tests for a section independent from section graph.
 */
public class TestOrphanSectionWithItems {

    SuperSlimAdapter<String, RecyclerView.ViewHolder> adapter;

    Section section;

    @Test
    public void addsToSection() {
        Item first = new Item(0, ItemData.newInstance());
        Item second = new Item(0, ItemData.newInstance());
        Item third = new Item(0, ItemData.newInstance());

        // Test item adds.

        section.add(first);
        assertThat(section, hasChildCount(equalTo(1)));
        assertThat((Item) section.get(0), is(equalTo(first)));

        section.add(second);
        assertThat(section, hasChildCount(equalTo(2)));
        assertThat((Item) section.get(0), is(equalTo(first)));
        assertThat((Item) section.get(1), is(equalTo(second)));

        section.add(third);
        assertThat(section, hasChildCount(equalTo(3)));
        assertThat((Item) section.get(0), is(equalTo(first)));
        assertThat((Item) section.get(1), is(equalTo(second)));
        assertThat((Item) section.get(2), is(equalTo(third)));
    }

    @Test
    public void insertsToSection() {
        Item first = new Item(0, ItemData.newInstance());
        Item second = new Item(0, ItemData.newInstance());
        Item third = new Item(0, ItemData.newInstance());

        Item start = new Item(0, ItemData.newInstance());
        Item middle = new Item(0, ItemData.newInstance());
        Item end = new Item(0, ItemData.newInstance());

        section.add(first);
        section.add(second);
        section.add(third);

        // Test item insertion.

        section.insert(0, start);
        assertThat(section, hasChildCount(equalTo(4)));
        assertThat((Item) section.get(0), is(equalTo(start)));
        assertThat((Item) section.get(1), is(equalTo(first)));
        assertThat((Item) section.get(2), is(equalTo(second)));
        assertThat((Item) section.get(3), is(equalTo(third)));

        section.insert(-1, end);
        assertThat(section, hasChildCount(equalTo(5)));
        assertThat((Item) section.get(0), is(equalTo(start)));
        assertThat((Item) section.get(1), is(equalTo(first)));
        assertThat((Item) section.get(2), is(equalTo(second)));
        assertThat((Item) section.get(3), is(equalTo(third)));
        assertThat((Item) section.get(4), is(equalTo(end)));

        section.insert(2, middle);
        assertThat(section, hasChildCount(equalTo(6)));
        assertThat((Item) section.get(0), is(equalTo(start)));
        assertThat((Item) section.get(1), is(equalTo(first)));
        assertThat((Item) section.get(2), is(equalTo(middle)));
        assertThat((Item) section.get(3), is(equalTo(second)));
        assertThat((Item) section.get(4), is(equalTo(third)));
        assertThat((Item) section.get(5), is(equalTo(end)));
    }

    @Test
    public void moveItemsAroundSection() {

    }

    @Test
    public void removesFromSection() {
        Item first = new Item(0, ItemData.newInstance());
        Item second = new Item(0, ItemData.newInstance());
        Item third = new Item(0, ItemData.newInstance());
        Item fourth = new Item(0, ItemData.newInstance());
        Item fifth = new Item(0, ItemData.newInstance());

        section.add(first);
        section.add(second);
        section.add(third);
        section.add(fourth);
        section.add(fifth);

        // Test item removals.

        section.remove(2);
        assertThat(section, hasChildCount(equalTo(4)));
        assertThat((Item) section.get(0), is(equalTo(first)));
        assertThat((Item) section.get(1), is(equalTo(second)));
        assertThat((Item) section.get(2), is(equalTo(fourth)));
        assertThat((Item) section.get(3), is(equalTo(fifth)));

        section.remove(3);
        assertThat(section, hasChildCount(equalTo(3)));
        assertThat((Item) section.get(0), is(equalTo(first)));
        assertThat((Item) section.get(1), is(equalTo(second)));
        assertThat((Item) section.get(2), is(equalTo(fourth)));

        section.remove(0);
        assertThat(section, hasChildCount(equalTo(2)));
        assertThat((Item) section.get(0), is(equalTo(second)));
        assertThat((Item) section.get(1), is(equalTo(fourth)));

        section.remove(1);
        assertThat(section, hasChildCount(equalTo(1)));
        assertThat((Item) section.get(0), is(equalTo(second)));

        section.remove(0);
        assertThat(section, hasChildCount(equalTo(0)));
    }

    @Before
    public void setup() {
        adapter = new AdapterStub();
        section = adapter.createSection("id");
    }
}