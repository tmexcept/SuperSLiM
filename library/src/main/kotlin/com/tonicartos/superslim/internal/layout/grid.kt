package com.tonicartos.superslim.internal.layout

import com.tonicartos.superslim.*
import com.tonicartos.superslim.adapter.HeaderStyle
import com.tonicartos.superslim.internal.SectionState
import com.tonicartos.superslim.internal.SectionState.LayoutState

class GridSectionConfig(gutterStart: Int = SectionConfig.DEFAULT_GUTTER, gutterEnd: Int = SectionConfig.DEFAULT_GUTTER,
                        @HeaderStyle headerStyle: Int = SectionConfig.DEFAULT_HEADER_STYLE) : SectionConfig(gutterStart, gutterEnd, headerStyle),
                                                                                              ColumnsSectionConfigurationMixin by ColumnsConfiguration() {

    override protected fun onMakeSection(oldState: SectionState?): SectionState = GridSectionState(this, oldState)

    override protected fun onCopy(): GridSectionConfig {
        val copy = GridSectionConfig(gutterStart, gutterEnd, headerStyle)
        copy.numColumns = numColumns
        copy.columnWidth = columnWidth
        return copy
    }
}

private class GridSectionState(var configuration: GridSectionConfig, oldState: SectionState? = null) : SectionState(configuration, oldState),
                                                                                                       ColumnsSectionStateMixin by ColumnsState(configuration) {
    override fun doLayout(helper: LayoutHelper, layoutState: LayoutState) {
        resolveColumns(helper)

        GridSlm.onLayout(helper, this, layoutState)
    }

    override fun doFillTop(dy: Int, helper: LayoutHelper, layoutState: LayoutState): Int {
        throw UnsupportedOperationException()
    }

    override fun doFillBottom(dy: Int, helper: LayoutHelper, layoutState: LayoutState): Int {
        throw UnsupportedOperationException()
    }

    override fun doTrimTop(helper: LayoutHelper, layoutState: LayoutState) {
        throw UnsupportedOperationException()
    }

    override fun doTrimBottom(helper: LayoutHelper, layoutState: LayoutState) {
        throw UnsupportedOperationException()
    }
}

private object GridSlm : SectionLayoutManager<GridSectionState> {
    override fun onLayout(helper: LayoutHelper, section: GridSectionState, state: LayoutState) {
        throw UnsupportedOperationException()
    }

    override fun onFillTop(dy: Int, helper: LayoutHelper, section: GridSectionState, state: LayoutState): Int {
        throw UnsupportedOperationException()
    }

    override fun onFillBottom(dy: Int, helper: LayoutHelper, section: GridSectionState, layoutState: LayoutState): Int {
        throw UnsupportedOperationException()
    }

    override fun onTrimTop(helper: LayoutHelper, section: GridSectionState, layoutState: LayoutState) {
        throw UnsupportedOperationException()
    }

    override fun onTrimBottom(helper: LayoutHelper, section: GridSectionState, layoutState: LayoutState) {
        throw UnsupportedOperationException()
    }
}
