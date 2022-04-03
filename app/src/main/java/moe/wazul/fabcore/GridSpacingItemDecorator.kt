package moe.wazul.fabcore

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class GridSpacingItemDecorator(private val spacing : Float, private val includeEdge: Boolean = true) : RecyclerView.ItemDecoration()
{
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State)
    {
        val gridLayoutManager : GridLayoutManager = parent.layoutManager as GridLayoutManager
        val spanCount : Int = gridLayoutManager.spanCount
        val spacingPx : Int = (spacing * parent.context.resources.displayMetrics.density).roundToInt()

        val position : Int = parent.getChildAdapterPosition(view)
        val column : Int = position % spanCount

        if (includeEdge)
        {
            outRect.left = spacingPx - column * spacingPx / spanCount
            outRect.right = (column + 1) * spacingPx / spanCount

            if (position < spanCount)
            {
                outRect.top = spacingPx
            }

            outRect.bottom = spacingPx
        }
        else
        {
            outRect.left = column * spacingPx / spanCount
            outRect.right = spacingPx - (column + 1) * spacingPx / spanCount

            if (position >= spanCount)
            {
                  outRect.top = spacingPx
            }
        }
    }
}
