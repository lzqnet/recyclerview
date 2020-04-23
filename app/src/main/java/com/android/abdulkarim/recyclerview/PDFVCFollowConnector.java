package com.android.abdulkarim.recyclerview;

import android.graphics.Rect;
import android.os.SystemClock;

import android.text.TextUtils;
import android.view.View;

import java.lang.ref.WeakReference;
//
//import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
//import static com.bytedance.ee.bear.drive.common.DriveConstants.COMMIT_DELAY_TIME;
//
public class PDFVCFollowConnector  {
//    private final static String TAG = DriveConstants.VC_FOLLOW_MODULE_TAG;
//    private final static String MODULE_NAME = "pdf";
//    private final static String ACTION_TYPE = "drive_pdf_update";
//
//    private WeakReference<RecyclerView> mRecyclerView;
//    private ScrollListener mScrollListener;
//    private ExhibitionModeChangeListener mExhibitionModeListener;
//    private PDFModuleStateListener mPdfModuleStateListener;
//    private WeakReference<IPDFViewAbstractLayer> mFollowView;
//    private FollowableContentDelegate mFollowableContentDelegate;
//
//    public PDFVCFollowConnector() {
//        mPdfModuleStateListener = new PDFModuleStateListener();
//        mScrollListener = new ScrollListener(mPdfModuleStateListener);
//        mExhibitionModeListener = new ExhibitionModeChangeListener(mPdfModuleStateListener);
//    }
//
//    /**
//     * 找出数组中最大的元素
//     */
//    private static int findMax(int[] array) {
//        if (array == null || array.length <= 0) {
//            return Integer.MIN_VALUE;
//        }
//        int max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            int v = array[i];
//            if (v > max) {
//                max = v;
//            }
//        }
//        return max;
//    }
//
//    /**
//     * 找出数组中最小的元素
//     */
//    private static int findMin(int[] array) {
//        if (array == null || array.length <= 0) {
//            return Integer.MAX_VALUE;
//        }
//        int min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            int v = array[i];
//            if (v < min) {
//                min = v;
//            }
//        }
//        return min;
//    }
//
//    private static Rect calcViewScreenLocation(View view) {
//        if (view == null) {
//            return new Rect(0, 0, 0, 0);
//        }
//        int[] location = new int[2];
//        // 获取控件在屏幕中的位置，返回的数组分别为控件左顶点的 x、y 的值
//        view.getLocationOnScreen(location);
//        return new Rect(location[0], location[1], location[0] + view.getWidth(),
//            location[1] + view.getHeight());
//    }
//
//    @NonNull
//    @Override
//    public String getModule() {
//        return MODULE_NAME;
//    }
//
//    @Override
//    public void refresh() {
//
//    }
//
//    @Nullable
//    @Override
//    public FollowModuleState getState() {
//       return generateFollowModuleState();
//    }
//
//    @Override
//    public void setState(@NonNull FollowModuleState state) {
//        if (state != null && TextUtils.equals(state.module, MODULE_NAME)) {
//            if(FollowConstants.DEBUG) {
//                Log.d(TAG, "PDFVCFollowConnector setState: state=" + state.toString());
//            }
//            DrivePdfState drivePdfState = parsePDFState(state.data);
//            doRemoteAction(drivePdfState);
//        } else {
//            Log.w(TAG, "PDFVCFollowConnector.java.setState: STATE is invalid state=" + state == null
//                ? "null" : state.toString());
//        }
//    }
//
//    @Override
//    public void setDelegate(FollowableContentDelegate delegate) {
//        mFollowableContentDelegate = delegate;
//    }
//
//    public void setFollowDocumentInfo(IPDFViewAbstractLayer mFollowView) {
//        this.mRecyclerView = new WeakReference<>(mFollowView.getNormalModeFollowView());
//        this.mFollowView = new WeakReference<>(mFollowView);
//        mFollowView.getNormalModeFollowView().addOnScrollListener(mScrollListener);
//        mFollowView.setPDFActionListener(mExhibitionModeListener);
//
//    }
//
//    /**
//     * Returns the position within the adapter's data set for the first item
//     * displayed on screen. this method exclude hide(gone or height is 0) item.
//     *
//     * @return The position within the adapter's data set
//     */
//    private int getFirstVisiblePositionWithoutHideItem() {
//        if (mRecyclerView == null || mFollowView == null) {
//            return RecyclerView.NO_POSITION;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//        if (recyclerView == null) {
//            return RecyclerView.NO_POSITION;
//        }
//        int[] mTempPosArray = null;
//        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
//        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//            final StaggeredGridLayoutManager staggeredGridLayoutManager =
//                (StaggeredGridLayoutManager) layoutManager;
//            final int spanCount = staggeredGridLayoutManager.getSpanCount();
//            if (spanCount <= 0) {
//                return RecyclerView.NO_POSITION;
//            }
//            if (mTempPosArray == null || mTempPosArray.length < spanCount) {
//                mTempPosArray = new int[spanCount];
//            }
//            staggeredGridLayoutManager.findFirstVisibleItemPositions(mTempPosArray);
//            return findMin(mTempPosArray);
//        } else if (recyclerView.getChildCount() > 0) {
//            return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
//        } else {
//            return RecyclerView.NO_POSITION;
//        }
//    }
//
//    public void titleChange(String titleContent){
//        if (mFollowableContentDelegate != null) {
//            TitleChangedEvent event = new TitleChangedEvent(titleContent);
//            mFollowableContentDelegate.onContentEvent(event);
//        }
//    }
//
//    public void downLoadStateChange(DownLoadState state) {
//        if (mFollowableContentDelegate != null) {
//            LoadStateChangedEvent event = new LoadStateChangedEvent(transformLoadState(state));
//            mFollowableContentDelegate.onContentEvent(event);
//        }
//    }
//
//    private LoadStateChangedEvent.LoadState transformLoadState(DownLoadState downLoadState) {
//        if (downLoadState == null) {
//            return LoadStateChangedEvent.LoadState.LoadFail;
//        }
//        switch (downLoadState) {
//            case Loading:
//                return LoadStateChangedEvent.LoadState.Loading;
//            case LoadSuccess:
//                return LoadStateChangedEvent.LoadState.LoadSuccess;
//            default:
//                return LoadStateChangedEvent.LoadState.LoadFail;
//        }
//    }
//
//    /**
//     * Returns the position within the adapter's data set for the last item
//     * displayed on screen.
//     *
//     * @return The position within the adapter's data set
//     */
//    private int getLastVisiblePosition() {
//        if (mRecyclerView == null || mFollowView == null) {
//            return RecyclerView.NO_POSITION;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//
//        if (recyclerView == null) {
//            return RecyclerView.NO_POSITION;
//        }
//        int[] mTempPosArray = null;
//
//        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
//        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//            final StaggeredGridLayoutManager staggeredGridLayoutManager =
//                (StaggeredGridLayoutManager) layoutManager;
//            final int spanCount = staggeredGridLayoutManager.getSpanCount();
//            if (spanCount <= 0) {
//                return RecyclerView.NO_POSITION;
//            }
//            if (mTempPosArray == null || mTempPosArray.length < spanCount) {
//                mTempPosArray = new int[spanCount];
//            }
//            staggeredGridLayoutManager.findLastVisibleItemPositions(mTempPosArray);
//            return findMax(mTempPosArray);
//        } else if (recyclerView.getChildCount() > 0) {
//            return recyclerView.getChildAdapterPosition(
//                recyclerView.getChildAt(recyclerView.getChildCount() - 1));
//        } else {
//            return RecyclerView.NO_POSITION;
//        }
//    }
//
//    /**
//     * @param position pdf page index
//     * @param offset the position offset (by px)
//     */
//    private void scrollToTargetPositionInternal(final int position, final int offset) {
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.scrollToTargetPositionInternal: 209");
//            return;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//
//        if (recyclerView == null) {
//            Log.w(TAG, "scrollToTargetPositionInternal: recyclerview is invalid");
//            return;
//        }
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//           // ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, offset);
//             TestLinearSmoothScrollerExt testLinearSmoothScrollerExt;
//            testLinearSmoothScrollerExt=new TestLinearSmoothScrollerExt(recyclerView.getContext());
//
//            testLinearSmoothScrollerExt.setTargetPosition(position);
//            testLinearSmoothScrollerExt.setFitPadding(offset);
//            ((LinearLayoutManager) layoutManager).startSmoothScroll(testLinearSmoothScrollerExt);
//        } else {
//            Log.w(TAG, "scrollToTargetPositionInternal: invalid LayoutManager");
//        }
//    }
//
//    public void doRemoteAction(DrivePdfState state) {
//        if (mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.doRemoteAction: 228");
//            return;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (state == null || layer == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.doRemoteAction: STATE in null or layer is null");
//            return;
//        }
//        if (state.isIsPresentationMode()
//            && layer.getCurrentMode() != ExhibitionMode.PRESENTATION) {
//            layer.setExhibitionMode(ExhibitionMode.PRESENTATION);
//        } else if (!state.isIsPresentationMode()
//            && layer.getCurrentMode() != ExhibitionMode.NORMAL) {
//            layer.setExhibitionMode(ExhibitionMode.NORMAL);
//        }
//        /**
//         * scroll
//         */
//        if (layer.getCurrentMode() == ExhibitionMode.PRESENTATION) {
//            layer.setPresentationPage(state.getPageNumber());
//        } else {
//            scrollToTargetPosition(state.getPageNumber() - 1,
//                state.getPageOffsetTop());
//            layer.setCurrentPosition(state.getPageNumber());
//        }
//    }
//
//    /**
//     * @param position page item index
//     */
//    private void scrollToTargetPosition(int position) {
//        if (mRecyclerView == null || mFollowView == null) {
//            return;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//
//        if (layer == null) {
//            Log.w(TAG, "scrollToTargetPosition: layer is invalid");
//            return;
//        }
//
//        try {
//            if (position < layer.getPageCount() && position >= 0) {
//                scrollToTargetPositionInternal(position, 0);
//            } else {
//                Log.w(TAG,
//                    "PDFVCFollowConnector.java.scrollToTargetPosition: position=" + position);
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "scrollToTargetPosition: ", e);
//        }
//    }
//
//    /**
//     * @param position page item index.
//     */
//    private void scrollToTargetPosition(int position, final float offsetPercent) {
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.scrollToTargetPosition: 285");
//            return;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        RecyclerView recyclerView = mRecyclerView.get();
//
//        if (recyclerView == null || layer == null) {
//            Log.w(TAG, "scrollToTargetPosition: recyclerview is invalid or layer is invalid");
//            return;
//        }
//        position = position >= layer.getPageCount() ? layer.getPageCount() - 1 : position;
//        position = position < 0 ? 0 : position;
//
//        try {
//            int pageHeight = layer.getPageHeight(position);
//            if (pageHeight > 0) {
//                int recyclerViewHeigh = recyclerView.getHeight();
//                int medianLineHeight = recyclerViewHeigh / 2;
//                int offset = (int) (medianLineHeight - pageHeight * offsetPercent);
//                offset = offset >= 0 ? offset : 0;
//                scrollToTargetPositionInternal(position, offset);
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "scrollToTargetPosition: ", e);
//        }
//    }
//
//    boolean isPresentationMode() {
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.isPresentationMode: 314");
//            return false;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (layer != null) {
//            return layer.getCurrentMode() == ExhibitionMode.PRESENTATION;
//        } else {
//            return false;
//        }
//    }
//
//    int getCurrentPageNum() {
//        if (mRecyclerView == null || mFollowView == null) {
//            return RecyclerView.NO_POSITION;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (layer == null) {
//            return RecyclerView.NO_POSITION;
//        }
//
//        int position;
//        if (layer.getCurrentMode() == ExhibitionMode.NORMAL) {
//            position = findMiddleItem() + 1;
//        } else {
//            position = layer.getCurrentPage();
//        }
//        return position;
//    }
//
//    float getCurrentOffsetTop() {
//        return generateOffsetPercent(getCurrentPageNum());
//    }
//
//    private DrivePdfState generateDrivePDFState() {
//        DrivePdfState state = new DrivePdfState();
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.generateDrivePDFState: 350");
//            return state;
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (layer == null) {
//            return state;
//        }
//        int position;
//        if (layer.getCurrentMode() == ExhibitionMode.NORMAL) {
//            position = findMiddleItem() + 1;
//        } else {
//            position = layer.getCurrentPage();
//        }
//        boolean isPresentationMode = isPresentationMode();
//        state.setPageNumber(position);
//        state.setIsPresentationMode(isPresentationMode);
//        if (layer.getCurrentMode() != ExhibitionMode.PRESENTATION) {
//            state.setPageOffsetTop(generateOffsetPercent(position-1));
//        }
//        state.setScale(getScale());
//        state.setPageOffsetLeft(generateOffsetLeft());
//        return state;
//    }
//
//    private float generateOffsetLeft(){
//        //TODO: we dont support scale currently.the value is 1 now.
//        return 0.5f;
//    }
//
//    private float getScale(){
//        //TODO: we dont support scale currently.the value is 1 now.
//        return 1;
//    }
//
//    /**
//     *
//     * @param position [0,x)
//     * @return
//     */
//    private float generateOffsetPercent(int position) {
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.generateOffsetPercent: 374");
//            return RecyclerView.NO_POSITION;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//        IPDFViewAbstractLayer layer = mFollowView.get();
//
//        if (recyclerView == null || layer == null) {
//            Log.w(TAG, "generateOffsetPercent: recyclerview or layer is invalid");
//            return RecyclerView.NO_POSITION;
//        }
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (!(layoutManager instanceof LinearLayoutManager)) {
//            return 0;
//        }
//        View view = layoutManager.findViewByPosition(position);
//
//        Rect viewRect = calcViewScreenLocation(view);
//        Rect recyclerRect = calcViewScreenLocation(recyclerView);
//        float pageHeight = -1;
//
//        try {
//            if (position < layer.getPageCount() && position >= 0) {
//                pageHeight = layer.getPageHeight(position);
//                float offset = ((recyclerRect.top + recyclerRect.bottom) / 2) - viewRect.top;
//
//                if (pageHeight > 0 && offset > 0) {
//                    return offset / pageHeight;
//                }
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "scrollToTargetPosition: ", e);
//        }
//        return 0;
//    }
//
//    private int findMiddleItem() {
//        if (mRecyclerView == null || mFollowView == null) {
//            Log.w(TAG, "PDFVCFollowConnector.java.findMiddleItem: 411");
//            return RecyclerView.NO_POSITION;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (recyclerView == null || layer == null) {
//            Log.w(TAG, "findMiddleItem: recyclerview or layer is invalid");
//            return RecyclerView.NO_POSITION;
//        }
//        int middlePosition = RecyclerView.NO_POSITION;
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//
//            int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
//            int lastPosition = linearLayoutManager.findLastVisibleItemPosition();
//            if (firstPosition == lastPosition) {
//                return firstPosition;
//            }
//            middlePosition = (firstPosition + lastPosition) / 2;
//            if (positionIsMiddle(middlePosition)) {
//                Log.i(TAG, "findMiddleItem: middlePosition");
//                return middlePosition;
//            } else if (positionIsMiddle(middlePosition - 1)) {
//                Log.i(TAG, "findMiddleItem: middlePosition-1");
//                return middlePosition - 1;
//            } else if (positionIsMiddle(middlePosition + 1)) {
//                Log.i(TAG, "findMiddleItem: middlePosition+1");
//                return middlePosition + 1;
//            } else {
//                Log.w(TAG, "findMiddleItem: failed");
//                return RecyclerView.NO_POSITION;
//            }
//        }
//        return RecyclerView.NO_POSITION;
//    }
//
//    private boolean positionIsMiddle(int position) {
//        if (mRecyclerView == null || mFollowView == null) {
//            return false;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//        IPDFViewAbstractLayer layer = mFollowView.get();
//
//        if (recyclerView == null || layer == null) {
//            Log.w(TAG, "positionIsMiddle: recyclerview or layer is invalid");
//            return false;
//        }
//        if (position < 0 || position >= layer.getPageCount()) {
//            Log.w(TAG, "positionIsMiddle: position is invaild");
//            return false;
//        }
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        Rect recyclerRect = calcViewScreenLocation(recyclerView);
//        if (layoutManager instanceof LinearLayoutManager) {
//            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//            View itemView = linearLayoutManager.findViewByPosition(position);
//            Rect viewRect = calcViewScreenLocation(itemView);
//            return viewRect.contains((recyclerRect.left + recyclerRect.right) / 2,
//                (recyclerRect.top + recyclerRect.bottom) / 2);
//
//            //return locationIsinView((recyclerRect.left + recyclerRect.right) / 2,
//            //    (recyclerRect.top + recyclerRect.bottom) / 2, itemView);
//        }
//        return false;
//    }
//
//    private FollowModuleState generateFollowModuleState() {
//        DrivePdfState pdfState = generateDrivePDFState();
//        return new FollowModuleState(MODULE_NAME, ACTION_TYPE, toJson(pdfState));
//    }
//
//    private String toJson(DrivePdfState state) {
//        return JSON.toJSONString(state);
//    }
//
//    private DrivePdfState parsePDFState(String stateJson) {
//        try {
//            return JSON.parseObject(stateJson, DrivePdfState.class);
//        } catch (Exception e) {
//            Log.e(TAG, "parseState: ", e);
//        }
//        return new DrivePdfState();
//    }
//
//    public void onDetach() {
//        if (mRecyclerView == null || mFollowView == null) {
//            return;
//        }
//        RecyclerView recyclerView = mRecyclerView.get();
//        if (recyclerView != null) {
//            recyclerView.removeOnScrollListener(mScrollListener);
//        }
//        IPDFViewAbstractLayer layer = mFollowView.get();
//        if (layer != null) {
//            layer.setPDFActionListener(null);
//        }
//    }
//
//    private static class ScrollListener extends RecyclerView.OnScrollListener {
//        PDFModuleStateListener pdfModuleStateListener;
//
//        public ScrollListener(PDFModuleStateListener pdfModuleStateListener) {
//            this.pdfModuleStateListener = pdfModuleStateListener;
//        }
//
//        @Override
//        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//            super.onScrollStateChanged(recyclerView, newState);
//            Log.d(TAG, "ScrollListener onScrollStateChanged: ");
//            if (newState == SCROLL_STATE_IDLE) {
//                pdfModuleStateListener.onStateChange();
//            }
//        }
//
//        @Override
//        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//            super.onScrolled(recyclerView, dx, dy);
//        }
//    }
//
//    private static class ExhibitionModeChangeListener
//        implements IPDFViewAbstractLayer.IPDFActionListener {
//        PDFModuleStateListener pdfModuleStateListener;
//
//        public ExhibitionModeChangeListener(PDFModuleStateListener pdfModuleStateListener) {
//            this.pdfModuleStateListener = pdfModuleStateListener;
//        }
//
//        @Override
//        public void onExhibitionModeChanged(ExhibitionMode mode, int pageIndex) {
//            Log.d(TAG, "ExhibitionModeChangeListener onExhibitionModeChanged: ");
//            pdfModuleStateListener.onStateChange();
//        }
//
//        @Override
//        public void onScrollChange(int position) {
//            Log.d(TAG, "ExhibitionModeChangeListener onScrollChange: ");
//            pdfModuleStateListener.onStateChange();
//        }
//    }
//
//    private class PDFModuleStateListener {
//        private long lastCommitTime = SystemClock.uptimeMillis();
//
//        void onStateChange() {
//            Log.d(TAG, "onStateChange: ");
//            if (SystemClock.uptimeMillis() - lastCommitTime < COMMIT_DELAY_TIME) {
//                return;
//            }
//            lastCommitTime = SystemClock.uptimeMillis();
//            //TODO: send state
//            FollowModuleState followModuleState = generateFollowModuleState();
//            if (mFollowableContentDelegate != null) {
//                Log.d(TAG, "onStateChange: followModuleState="+followModuleState.toString());
//                mFollowableContentDelegate.onStateChanged(followModuleState);
//            }
//        }
//    }
}
