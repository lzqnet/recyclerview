package com.android.abdulkarim.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.abdulkarim.recyclerview.adapter.ContactAdapter;
import com.android.abdulkarim.recyclerview.common.Data;
import com.android.abdulkarim.recyclerview.interfaces.OnItemClickListener;
import com.android.abdulkarim.recyclerview.model.Contact;
import com.zhiqing.recyclerview_lib.recyclerview.widget.LinearLayoutManager;
import com.zhiqing.recyclerview_lib.recyclerview.widget.RecyclerView;
import com.zhiqing.recyclerview_lib.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private final static String TAG = "MainActivity";
    private List<Contact> contactList;
    private RecyclerView recyclerView;
    EditText positionEdittext;
    Button scrollToPosition;

    EditText offsetEdittext;
    Button scrollToOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = new Data().getContactList();
        ContactAdapter contactAdapter = new ContactAdapter(contactList, this);
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        positionEdittext = findViewById(R.id.edit);
        scrollToPosition = findViewById(R.id.scroll_to_position);

        offsetEdittext = findViewById(R.id.edit_offset);
        //offsetEdittext.setFilters(new InputFilter[]{new EdittextFilter().setDigits(3)});
        scrollToOffset = findViewById(R.id.scroll_to_offset);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Time : " + contactList.get(position).getcTime(), Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void onItemLongClick(int position) {

    }

    public void doOnClick(View view) {
        int position = Integer.MAX_VALUE;
        try {
            position = Integer.parseInt(positionEdittext.getText().toString().trim());
        } catch (Exception e) {

        }
        if (position != Integer.MAX_VALUE && position >= 0 && position < contactList.size()) {
           // recyclerView.smoothScrollToPosition(position);
            LinearLayoutManager layoutManager =
                (LinearLayoutManager) recyclerView.getLayoutManager();
            //layoutManager.scrollToPositionWithOffset(position, scrollLength);
            TestLinearSmoothScrollerExt testLinearSmoothScrollerExt;
            testLinearSmoothScrollerExt=new TestLinearSmoothScrollerExt(recyclerView.getContext());
            testLinearSmoothScrollerExt.setTargetPosition(position);
            layoutManager.startSmoothScroll(testLinearSmoothScrollerExt);
        }
    }

    private RecyclerView.ViewHolder findViewHolderByPosition(int position) {
        return recyclerView.findViewHolderForAdapterPosition(position);
    }




    private void scrollToRelativePosition(final int position, final float offset) {
        Log.d(TAG, "scrollToRelativePosition: getFirstVisiblePositionWithoutHideItem()="
            + getFirstVisiblePositionWithoutHideItem());
        Log.d(TAG,
            "scrollToRelativePosition: getLastVisiblePosition()=" + getLastVisiblePosition());
        int firstVisiblePosition = getFirstVisiblePositionWithoutHideItem();
        int lastVisiblePosition = getLastVisiblePosition();
        //if (firstVisiblePosition != RecyclerView.NO_POSITION
        //    && position >= firstVisiblePosition
        //    && lastVisiblePosition != RecyclerView.NO_POSITION
        //    && position <= lastVisiblePosition) {
        //    Log.d(TAG, "scrollToRelativePosition: no change");
        //
        //} else {
        //    recyclerView.smoothScrollToPosition(position);
        //
        //}
        //recyclerView.post(new Runnable() {
        //    @Override
        //    public void run() {
        //        RecyclerView.ViewHolder viewHolder =
        //            recyclerView.findViewHolderForAdapterPosition(position);
        //        if (viewHolder != null) {
        //            int height = viewHolder.itemView.getMeasuredHeight();
        //            if (height != 0) {
        //                int scrollLength = (int) (height * offset);
        //                recyclerView.scrollBy(0, scrollLength);
        //            }
        //        }
        //    }
        //});
        RecyclerView.ViewHolder viewHolder =
            recyclerView.findViewHolderForAdapterPosition(position);
        if (viewHolder != null) {
            int height = viewHolder.itemView.getMeasuredHeight();
            if (height != 0) {
                int scrollLength = (int) (height * offset);
                LinearLayoutManager layoutManager =
                    (LinearLayoutManager) recyclerView.getLayoutManager();
                //layoutManager.scrollToPositionWithOffset(position, scrollLength);
                layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(),position);

            }
        }
    }

    /**
     * Returns the position within the adapter's data set for the first item
     * displayed on screen. this method exclude hide(gone or height is 0) item.
     *
     * @return The position within the adapter's data set
     */
    public int getFirstVisiblePositionWithoutHideItem() {
        int[] mTempPosArray = null;
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            final StaggeredGridLayoutManager staggeredGridLayoutManager =
                (StaggeredGridLayoutManager) layoutManager;
            final int spanCount = staggeredGridLayoutManager.getSpanCount();
            if (spanCount <= 0) {
                return RecyclerView.NO_POSITION;
            }
            if (mTempPosArray == null || mTempPosArray.length < spanCount) {
                mTempPosArray = new int[spanCount];
            }
            staggeredGridLayoutManager.findFirstVisibleItemPositions(mTempPosArray);
            return findMin(mTempPosArray);
        } else if (recyclerView.getChildCount() > 0) {
            return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
        } else {
            return RecyclerView.NO_POSITION;
        }
    }

    /**
     * Returns the position within the adapter's data set for the last item
     * displayed on screen.
     *
     * @return The position within the adapter's data set
     */
    public int getLastVisiblePosition() {
        int[] mTempPosArray = null;

        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            final StaggeredGridLayoutManager staggeredGridLayoutManager =
                (StaggeredGridLayoutManager) layoutManager;
            final int spanCount = staggeredGridLayoutManager.getSpanCount();
            if (spanCount <= 0) {
                return RecyclerView.NO_POSITION;
            }
            if (mTempPosArray == null || mTempPosArray.length < spanCount) {
                mTempPosArray = new int[spanCount];
            }
            staggeredGridLayoutManager.findLastVisibleItemPositions(mTempPosArray);
            return findMax(mTempPosArray);
        } else if (recyclerView.getChildCount() > 0) {
            return recyclerView.getChildAdapterPosition(
                recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        } else {
            return RecyclerView.NO_POSITION;
        }
    }

    public void doOnClickOffset(View view) {
        int position = Integer.MAX_VALUE;
        float offset = Float.MAX_VALUE;
        try {
            position = Integer.parseInt(positionEdittext.getText().toString().trim());
            offset = Float.parseFloat(offsetEdittext.getText().toString().trim());
        } catch (Exception e) {

        }
        if (position != Integer.MAX_VALUE && position >= 0 && position < contactList.size()) {
            scrollToRelativePosition(position, offset);
        }
    }

    /**
     * 找出数组中最大的元素
     */
    public static int findMax(int[] array) {
        if (array == null || array.length <= 0) {
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    /**
     * 找出数组中最小的元素
     */
    public static int findMin(int[] array) {
        if (array == null || array.length <= 0) {
            return Integer.MAX_VALUE;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            if (v < min) {
                min = v;
            }
        }
        return min;
    }
}
