package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u008b\u00022\u00020\u0001:\u000e\u0088\u0002\u0089\u0002\u008a\u0002\u008b\u0002\u008c\u0002\u008d\u0002\u008e\u0002B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010|\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\f2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u00062\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\u0013\u0010\u0083\u0001\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0084\u0001J\u001d\u0010\u0085\u0001\u001a\u00020\u001e2\u0007\u0010\u0086\u0001\u001a\u00020\f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u001e2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002J4\u0010\u0089\u0001\u001a\u00020\u000e2\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0007\u0010\u008b\u0001\u001a\u00020\f2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001JC\u0010\u0089\u0001\u001a\u00020\u000e2\r\u00102\u001a\t\u0012\u0004\u0012\u0002040\u0090\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0007\u0010\u008b\u0001\u001a\u00020\f2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u0094\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J!\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0006\u0010}\u001a\u00020\f2\u0007\u0010\u0097\u0001\u001a\u00020\fH\u0001¢\u0006\u0003\b\u0098\u0001J\u0013\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u007f2\u0006\u0010}\u001a\u00020\fH\u0002JD\u0010\u009a\u0001\u001a\u00030\u0096\u00012\u0006\u0010}\u001a\u00020\f2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0003\u0010\u009f\u0001J\u0011\u0010 \u0001\u001a\u00020\u000e2\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0013\u0010£\u0001\u001a\u00020^2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\u0013\u0010¦\u0001\u001a\u00020\f2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010©\u0001\u001a\u00020\f2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010ª\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0015\u0010«\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0016\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0017\u0010®\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0002J!\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\u0007\u0010±\u0001\u001a\u00020\fH\u0002J#\u0010²\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030´\u0001H\u0001¢\u0006\u0003\b¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J\u0013\u0010¸\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010¹\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\t\u0010º\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010»\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020rH\u0002J\u0013\u0010½\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0018\u0010¾\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020rH\u0000¢\u0006\u0003\b¿\u0001J\u000f\u0010À\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bÁ\u0001J&\u0010Â\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\f2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J$\u0010Ä\u0001\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010~\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030¨\u0001H\u0007J!\u0010Ç\u0001\u001a\u00020\u000e2\u0007\u0010È\u0001\u001a\u00020\f2\r\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020l0>H\u0002J\u0011\u0010Ê\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J&\u0010Ë\u0001\u001a\u0016\u0012\u0005\u0012\u00030¨\u00010Ì\u0001j\n\u0012\u0005\u0012\u00030¨\u0001`Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\f2\u0007\u0010È\u0001\u001a\u00020\fH\u0002J\u001c\u0010Ð\u0001\u001a\u00020\u001e2\b\u0010Ñ\u0001\u001a\u00030¨\u00012\u0007\u0010Ò\u0001\u001a\u00020dH\u0002J\"\u0010Ó\u0001\u001a\u00020\u001e2\b\u0010Ñ\u0001\u001a\u00030¨\u00012\u0007\u0010Ò\u0001\u001a\u00020dH\u0001¢\u0006\u0003\bÔ\u0001J\u001b\u0010Õ\u0001\u001a\u00020\u001e2\u0007\u0010È\u0001\u001a\u00020\f2\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010×\u0001\u001a\u00020\u000e2\b\u0010¡\u0001\u001a\u00030\u0096\u0001H\u0002J@\u0010Ø\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010\u0097\u0001\u001a\u00020\f2\u000b\b\u0002\u0010Ù\u0001\u001a\u0004\u0018\u00010\f2\u0011\b\u0002\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010>H\u0002¢\u0006\u0003\u0010Û\u0001J&\u0010Ü\u0001\u001a\u00020\u001e2\u0007\u0010Ý\u0001\u001a\u00020\f2\u0007\u0010Ù\u0001\u001a\u00020\f2\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010ß\u0001\u001a\u00020\u001e2\u0007\u0010Ý\u0001\u001a\u00020\fH\u0002J\u0012\u0010à\u0001\u001a\u00020\u001e2\u0007\u0010á\u0001\u001a\u00020lH\u0002J$\u0010â\u0001\u001a\u00020\u001e2\u0013\u0010ã\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020403H\u0001¢\u0006\u0003\bä\u0001J!\u0010å\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020r2\r\u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\f0%H\u0002J.\u0010ç\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010è\u0001\u001a\u00020\f2\u0007\u0010é\u0001\u001a\u00020\f2\u0007\u0010ê\u0001\u001a\u00020\u000eH\u0002J\u001c\u0010ë\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010ì\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010í\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010î\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\t\u0010ï\u0001\u001a\u00020\u001eH\u0002JG\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u0007\u0010Î\u0001\u001a\u00020\u000e2\u000e\u0010ñ\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u001c\b\u0002\u0010ò\u0001\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00010;0cH\u0002J)\u0010ó\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u0007\u0010Î\u0001\u001a\u00020\u000e2\u000e\u0010ô\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;H\u0002J\"\u0010õ\u0001\u001a\u0005\u0018\u00010ö\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010¨\u00012\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J.\u0010ú\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010±\u0001\u001a\u00020\f2\u0007\u0010û\u0001\u001a\u00020\u000e2\u0007\u0010ü\u0001\u001a\u00020\u000eH\u0002J4\u0010ý\u0001\u001a\u0005\u0018\u0001Hþ\u0001\"\t\b\u0000\u0010þ\u0001*\u00020\u001b2\n\u0010\u009e\u0001\u001a\u0005\u0018\u0001Hþ\u00012\t\b\u0001\u0010ÿ\u0001\u001a\u00020\fH\u0002¢\u0006\u0003\u0010\u0080\u0002J\u0011\u0010\u0081\u0002\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\fH\u0002J\t\u0010\u0082\u0002\u001a\u00020\u001eH\u0002J\u0010\u0010\u0083\u0002\u001a\u0004\u0018\u00010-*\u00030¥\u0001H\u0002J\u0011\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u0002*\u00030\u0086\u0002H\u0002J\u0010\u0010\u0087\u0002\u001a\u0004\u0018\u00010!*\u00030¨\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00148\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000204038@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010:\u001a&\u0012\f\u0012\n =*\u0004\u0018\u00010<0< =*\u0012\u0012\f\u0012\n =*\u0004\u0018\u00010<0<\u0018\u00010>0;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u00020@8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0016\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR6\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Mj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR6\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Mj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001a\u0010V\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0016\u001a\u0004\bX\u0010\u0010R\u0014\u0010Y\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0010R\u0014\u0010Z\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0010R\u0014\u0010[\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0010R \u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f030\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\f0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020d0c8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010\u0016\u001a\u0004\bf\u00106\"\u0004\bg\u00108R\u000e\u0010h\u001a\u00020dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010i\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010jR\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020l0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u001e0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020r0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010s\u001a\u00020t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u0010\u0016\u001a\u0004\bv\u0010wR\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u008f\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "EXTRA_DATA_TEST_TRAVERSALAFTER_VAL", "", "getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL$ui_release", "()Ljava/lang/String;", "EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL", "getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL$ui_release", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "getAccessibilityManager$ui_release$annotations", "()V", "getAccessibilityManager$ui_release", "()Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedContentCaptureAppearedNodes", "Landroidx/collection/ArrayMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "getBufferedContentCaptureAppearedNodes$ui_release", "()Landroidx/collection/ArrayMap;", "bufferedContentCaptureDisappearedNodes", "Landroidx/collection/ArraySet;", "getBufferedContentCaptureDisappearedNodes$ui_release", "()Landroidx/collection/ArraySet;", "checkingForSemanticsChanges", "contentCaptureForceEnabledForTesting", "getContentCaptureForceEnabledForTesting$ui_release", "setContentCaptureForceEnabledForTesting$ui_release", "contentCaptureSession", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Ljava/util/Map;", "setCurrentSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "currentSemanticsNodesInvalidated", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "getEnabledStateListener$ui_release$annotations", "getEnabledStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getIdToAfterMap$ui_release", "()Ljava/util/HashMap;", "setIdToAfterMap$ui_release", "(Ljava/util/HashMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "isEnabledForAccessibility", "isEnabledForContentCapture", "isTouchExplorationEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "getTouchExplorationStateListener$ui_release$annotations", "getTouchExplorationStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "viewStructure", "bufferContentCaptureViewDisappeared", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroid/text/SpannableString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifyContentCaptureChanges", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "notifySubtreeAppeared", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendContentCaptureSemanticsStructureChangeEvents", "sendContentCaptureSemanticsStructureChangeEvents$ui_release", "sendContentCaptureTextUpdateEvent", "newText", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getContentCaptureSessionCompat", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toViewStructure", "Api24Impl", "Api28Impl", "Api29Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    private final String EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private final ArrayMap<Integer, ViewStructureCompat> bufferedContentCaptureAppearedNodes;
    private final ArraySet<Integer> bufferedContentCaptureDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private boolean contentCaptureForceEnabledForTesting;
    private ContentCaptureSessionCompat contentCaptureSession;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private int hoveredVirtualViewId;
    private HashMap<Integer, Integer> idToAfterMap;
    private HashMap<Integer, Integer> idToBeforeMap;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private ArraySet<Integer> paneDisplayed;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAccessibilityManager$ui_release$annotations() {
    }

    public static /* synthetic */ void getEnabledStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    public static /* synthetic */ void getTouchExplorationStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.hoveredVirtualViewId = Integer.MIN_VALUE;
        Object systemService = this.view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat.this, z);
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat.this, z);
            }
        };
        this.enabledServices = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.bufferedContentCaptureAppearedNodes = new ArrayMap<>();
        this.bufferedContentCaptureDisappearedNodes = new ArraySet<>();
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.idToBeforeMap = new HashMap<>();
        this.idToAfterMap = new HashMap<>();
        this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        this.view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat.this.getAccessibilityManager().addAccessibilityStateChangeListener(AndroidComposeViewAccessibilityDelegateCompat.this.getEnabledStateListener());
                AndroidComposeViewAccessibilityDelegateCompat.this.getAccessibilityManager().addTouchExplorationStateChangeListener(AndroidComposeViewAccessibilityDelegateCompat.this.getTouchExplorationStateListener());
                AndroidComposeViewAccessibilityDelegateCompat.this.setContentCaptureSession$ui_release(AndroidComposeViewAccessibilityDelegateCompat.this.getContentCaptureSessionCompat(view2));
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                AndroidComposeViewAccessibilityDelegateCompat.this.getAccessibilityManager().removeAccessibilityStateChangeListener(AndroidComposeViewAccessibilityDelegateCompat.this.getEnabledStateListener());
                AndroidComposeViewAccessibilityDelegateCompat.this.getAccessibilityManager().removeTouchExplorationStateChangeListener(AndroidComposeViewAccessibilityDelegateCompat.this.getTouchExplorationStateListener());
                AndroidComposeViewAccessibilityDelegateCompat.this.setContentCaptureSession$ui_release(null);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$45(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeViewAccessibilityDelegateCompat.this.sendScrollEventIfNeeded(it);
            }
        };
    }

    /* renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    /* renamed from: getAccessibilityManager$ui_release, reason: from getter */
    public final android.view.accessibility.AccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    /* renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    /* renamed from: getEnabledStateListener$ui_release, reason: from getter */
    public final AccessibilityManager.AccessibilityStateChangeListener getEnabledStateListener() {
        return this.enabledStateListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List<AccessibilityServiceInfo> emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (enabled) {
            emptyList = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this$0.enabledServices = emptyList;
    }

    /* renamed from: getTouchExplorationStateListener$ui_release, reason: from getter */
    public final AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateListener() {
        return this.touchExplorationStateListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        return isEnabledForAccessibility() || getContentCaptureForceEnabledForTesting();
    }

    private final boolean isEnabledForAccessibility() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        if (this.accessibilityManager.isEnabled()) {
            List<AccessibilityServiceInfo> enabledServices = this.enabledServices;
            Intrinsics.checkNotNullExpressionValue(enabledServices, "enabledServices");
            if (!enabledServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isEnabledForContentCapture, reason: from getter */
    private final boolean getContentCaptureForceEnabledForTesting() {
        return this.contentCaptureForceEnabledForTesting;
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    public final boolean getContentCaptureForceEnabledForTesting$ui_release() {
        return this.contentCaptureForceEnabledForTesting;
    }

    public final void setContentCaptureForceEnabledForTesting$ui_release(boolean z) {
        this.contentCaptureForceEnabledForTesting = z;
    }

    /* renamed from: getContentCaptureSession$ui_release, reason: from getter */
    public final ContentCaptureSessionCompat getContentCaptureSession() {
        return this.contentCaptureSession;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    public final ArrayMap<Integer, ViewStructureCompat> getBufferedContentCaptureAppearedNodes$ui_release() {
        return this.bufferedContentCaptureAppearedNodes;
    }

    public final ArraySet<Integer> getBufferedContentCaptureDisappearedNodes$ui_release() {
        return this.bufferedContentCaptureDisappearedNodes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node, int action, int granularity, int fromIndex, int toIndex, long traverseTime) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.action = action;
            this.granularity = granularity;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.traverseTime = traverseTime;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    public final void setCurrentSemanticsNodes$ui_release(Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.currentSemanticsNodes = map;
    }

    public final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            setTraversalValues();
        }
        return this.currentSemanticsNodes;
    }

    public final HashMap<Integer, Integer> getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.idToBeforeMap = hashMap;
    }

    public final HashMap<Integer, Integer> getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.idToAfterMap = hashMap;
    }

    /* renamed from: getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL$ui_release, reason: from getter */
    public final String getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL() {
        return this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    }

    /* renamed from: getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL$ui_release, reason: from getter */
    public final String getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL() {
        return this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class SemanticsNodeCopy {
        private final Set<Integer> children;
        private final SemanticsNode semanticsNode;
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
            this.semanticsNode = semanticsNode;
            this.unmergedConfig = this.semanticsNode.getUnmergedConfig();
            this.children = new LinkedHashSet();
            List $this$fastForEach$iv = this.semanticsNode.getReplacedChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                SemanticsNode child = (SemanticsNode) item$iv;
                if (currentSemanticsNodes.containsKey(Integer.valueOf(child.getId()))) {
                    this.children.add(Integer.valueOf(child.getId()));
                }
            }
        }

        public final SemanticsNode getSemanticsNode() {
            return this.semanticsNode;
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    public final void setPreviousSemanticsNodes$ui_release(Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m4486canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        return m4487canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes$ui_release().values(), vertical, direction, position);
    }

    /* renamed from: canScroll-moWRBKg$ui_release, reason: not valid java name */
    public final boolean m4487canScrollmoWRBKg$ui_release(Collection<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey scrollRangeProperty;
        boolean z;
        Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
        if (Offset.m2707equalsimpl0(position, Offset.INSTANCE.m2725getUnspecifiedF1C5BW0()) || !Offset.m2713isValidimpl(position)) {
            return false;
        }
        if (vertical) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else {
            if (vertical) {
                throw new NoWhenBranchMatchedException();
            }
            scrollRangeProperty = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        Collection<SemanticsNodeWithAdjustedBounds> $this$any$iv = currentSemanticsNodes;
        if ($this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) element$iv;
            if (!RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m2736containsk4lQ0M(position)) {
                z = false;
            } else {
                ScrollAxisRange scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getConfig(), scrollRangeProperty);
                if (scrollRange == null) {
                    z = false;
                } else {
                    int actualDirection = scrollRange.getReverseScrolling() ? -direction : direction;
                    if (direction == 0 && scrollRange.getReverseScrolling()) {
                        actualDirection = -1;
                    }
                    z = actualDirection < 0 ? scrollRange.getValue().invoke().floatValue() > 0.0f : scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue();
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) == null) ? null : lifecycleRegistry.getState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat info = AccessibilityNodeInfoCompat.obtain();
        Intrinsics.checkNotNullExpressionValue(info, "obtain()");
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (virtualViewId == -1) {
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(this.view);
            info.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else if (semanticsNode.getParent() != null) {
            SemanticsNode parent = semanticsNode.getParent();
            Intrinsics.checkNotNull(parent);
            int parentId = parent.getId();
            if (parentId == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                parentId = -1;
            }
            info.setParent(this.view, parentId);
        } else {
            throw new IllegalStateException("semanticsNode " + virtualViewId + " has null parent");
        }
        info.setSource(this.view, virtualViewId);
        Rect boundsInRoot = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long topLeftInScreen = this.view.mo4148localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.left, boundsInRoot.top));
        long bottomRightInScreen = this.view.mo4148localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.right, boundsInRoot.bottom));
        info.setBoundsInScreen(new Rect((int) Math.floor(Offset.m2710getXimpl(topLeftInScreen)), (int) Math.floor(Offset.m2711getYimpl(topLeftInScreen)), (int) Math.ceil(Offset.m2710getXimpl(bottomRightInScreen)), (int) Math.ceil(Offset.m2711getYimpl(bottomRightInScreen))));
        populateAccessibilityNodeInfoProperties(virtualViewId, info, semanticsNode);
        return info.unwrap();
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        final Comparator comparator = ComparisonsKt.compareBy(new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$1
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SemanticsNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getBoundsInWindow().getLeft());
            }
        }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SemanticsNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getBoundsInWindow().getTop());
            }
        }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SemanticsNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getBoundsInWindow().getBottom());
            }
        }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SemanticsNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getBoundsInWindow().getRight());
            }
        });
        if (layoutIsRtl) {
            comparator = ComparisonsKt.compareBy(new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$1
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(SemanticsNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(it.getBoundsInWindow().getRight());
                }
            }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$2
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(SemanticsNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(it.getBoundsInWindow().getTop());
                }
            }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$3
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(SemanticsNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(it.getBoundsInWindow().getBottom());
                }
            }, new Function1<SemanticsNode, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$4
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(SemanticsNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(it.getBoundsInWindow().getLeft());
                }
            });
        }
        final Comparator<LayoutNode> zComparator$ui_release = LayoutNode.INSTANCE.getZComparator$ui_release();
        final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                SemanticsNode it = (SemanticsNode) t;
                SemanticsNode it2 = (SemanticsNode) t2;
                return zComparator$ui_release.compare(it.getLayoutNode(), it2.getLayoutNode());
            }
        };
        return new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator2.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                SemanticsNode it = (SemanticsNode) t;
                Integer valueOf = Integer.valueOf(it.getId());
                SemanticsNode it2 = (SemanticsNode) t2;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(it2.getId()));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, List list, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, list, map);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, List<SemanticsNode> parentListToSort, Map<Integer, List<SemanticsNode>> containerChildrenMapping) {
        List rowGroupings = new ArrayList();
        int entryIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        if (0 <= lastIndex) {
            while (true) {
                SemanticsNode currEntry = parentListToSort.get(entryIndex);
                if (entryIndex == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(rowGroupings, currEntry)) {
                    androidx.compose.ui.geometry.Rect newRect = currEntry.getBoundsInWindow();
                    rowGroupings.add(new Pair(newRect, CollectionsKt.mutableListOf(currEntry)));
                }
                if (entryIndex == lastIndex) {
                    break;
                }
                entryIndex++;
            }
        }
        CollectionsKt.sortWith(rowGroupings, ComparisonsKt.compareBy(new Function1<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Comparable<?> invoke2(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getFirst().getTop());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair) {
                return invoke2((Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair);
            }
        }, new Function1<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>, Comparable<?>>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Comparable<?> invoke2(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Float.valueOf(it.getFirst().getBottom());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair) {
                return invoke2((Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair);
            }
        }));
        List returnList = new ArrayList();
        int size = rowGroupings.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = rowGroupings.get(index$iv);
            Pair row = (Pair) item$iv;
            CollectionsKt.sortWith((List) row.getSecond(), semanticComparator(layoutIsRtl));
            returnList.addAll((Collection) row.getSecond());
        }
        CollectionsKt.sortWith(returnList, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                float getTraversalIndex;
                float getTraversalIndex2;
                SemanticsNode it = (SemanticsNode) t;
                getTraversalIndex = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getGetTraversalIndex(it);
                Float valueOf = Float.valueOf(getTraversalIndex);
                SemanticsNode it2 = (SemanticsNode) t2;
                getTraversalIndex2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getGetTraversalIndex(it2);
                return ComparisonsKt.compareValues(valueOf, Float.valueOf(getTraversalIndex2));
            }
        });
        int i = 0;
        while (i <= CollectionsKt.getLastIndex(returnList)) {
            int currNodeId = ((SemanticsNode) returnList.get(i)).getId();
            List it = containerChildrenMapping.get(Integer.valueOf(currNodeId));
            if (it != null) {
                returnList.remove(i);
                returnList.addAll(i, it);
            }
            List<SemanticsNode> list = containerChildrenMapping.get(Integer.valueOf(currNodeId));
            i += list != null ? list.size() : 1;
        }
        return returnList;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(List<Pair<androidx.compose.ui.geometry.Rect, List<SemanticsNode>>> list, SemanticsNode node) {
        boolean overlaps;
        float entryTopCoord = node.getBoundsInWindow().getTop();
        float entryBottomCoord = node.getBoundsInWindow().getBottom();
        OpenEndRange entryRange = AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(entryTopCoord, entryBottomCoord);
        int currIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (0 > lastIndex) {
            return false;
        }
        while (true) {
            androidx.compose.ui.geometry.Rect currRect = list.get(currIndex).getFirst();
            OpenEndRange groupRange = AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(currRect.getTop(), currRect.getBottom());
            overlaps = AndroidComposeViewAccessibilityDelegateCompat_androidKt.overlaps(groupRange, entryRange);
            if (!overlaps) {
                if (currIndex == lastIndex) {
                    return false;
                }
                currIndex++;
            } else {
                androidx.compose.ui.geometry.Rect newRect = currRect.intersect(new androidx.compose.ui.geometry.Rect(0.0f, entryTopCoord, Float.POSITIVE_INFINITY, entryBottomCoord));
                list.set(currIndex, new Pair<>(newRect, list.get(currIndex).getSecond()));
                list.get(currIndex).getSecond().add(node);
                return true;
            }
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        Map containerMapToChildren = new LinkedHashMap();
        List geometryList = new ArrayList();
        int size = listToSort.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = listToSort.get(index$iv);
            SemanticsNode node = (SemanticsNode) item$iv;
            subtreeSortedByGeometryGrouping$depthFirstSearch(this, geometryList, containerMapToChildren, layoutIsRtl, node);
        }
        List $this$fastForEach$iv = sortByGeometryGroupings(layoutIsRtl, geometryList, containerMapToChildren);
        return $this$fastForEach$iv;
    }

    private static final void subtreeSortedByGeometryGrouping$depthFirstSearch(AndroidComposeViewAccessibilityDelegateCompat this$0, List<SemanticsNode> list, Map<Integer, List<SemanticsNode>> map, boolean $layoutIsRtl, SemanticsNode currNode) {
        Boolean isTraversalGroup;
        Boolean isTraversalGroup2;
        isTraversalGroup = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTraversalGroup(currNode);
        if ((Intrinsics.areEqual((Object) isTraversalGroup, (Object) true) || this$0.isScreenReaderFocusable(currNode)) && this$0.getCurrentSemanticsNodes$ui_release().keySet().contains(Integer.valueOf(currNode.getId()))) {
            list.add(currNode);
        }
        isTraversalGroup2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTraversalGroup(currNode);
        if (Intrinsics.areEqual((Object) isTraversalGroup2, (Object) true)) {
            map.put(Integer.valueOf(currNode.getId()), this$0.subtreeSortedByGeometryGrouping($layoutIsRtl, CollectionsKt.toMutableList((Collection) currNode.getChildren())));
            return;
        }
        List $this$fastForEach$iv = currNode.getChildren();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            subtreeSortedByGeometryGrouping$depthFirstSearch(this$0, list, map, $layoutIsRtl, child);
        }
    }

    private final void setTraversalValues() {
        boolean layoutIsRtl;
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(-1);
        SemanticsNode hostSemanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(hostSemanticsNode);
        layoutIsRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(hostSemanticsNode);
        List semanticsOrderList = subtreeSortedByGeometryGrouping(layoutIsRtl, CollectionsKt.mutableListOf(hostSemanticsNode));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex(semanticsOrderList);
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int prevId = semanticsOrderList.get(i - 1).getId();
            int currId = semanticsOrderList.get(i).getId();
            this.idToBeforeMap.put(Integer.valueOf(prevId), Integer.valueOf(currId));
            this.idToAfterMap.put(Integer.valueOf(currId), Integer.valueOf(prevId));
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        String infoContentDescriptionOrNull;
        infoContentDescriptionOrNull = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(node);
        boolean isSpeakingNode = (infoContentDescriptionOrNull == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null && !getInfoIsCheckable(node)) ? false : true;
        return node.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (node.isUnmergedLeafNode$ui_release() && isSpeakingNode);
    }

    public final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        boolean isTextField;
        String infoContentDescriptionOrNull;
        boolean isPassword;
        boolean isTextField2;
        boolean enabled;
        boolean isVisible;
        boolean enabled2;
        boolean enabled3;
        AccessibilityAction scrollAction;
        ScrollAxisRange yScrollState;
        boolean enabled4;
        boolean enabled5;
        boolean isRtl;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        boolean isRtl2;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean enabled6;
        boolean excludeLineAndPageGranularities;
        boolean enabled7;
        boolean enabled8;
        String className;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        info.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.getValue();
            if (semanticsNode.getIsFake() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4574getTabo7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else if (!Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4573getSwitcho7Vup1c())) {
                    className = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m4489toLegacyClassNameV4PA4sw(role.getValue());
                    if (!Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4571getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                        info.setClassName(className);
                    }
                } else {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
        if (isTextField) {
            info.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            info.setClassName(TextClassName);
        }
        info.setPackageName(this.view.getContext().getPackageName());
        info.setImportantForAccessibility(true);
        List $this$fastForEach$iv = semanticsNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId()))) {
                AndroidViewHolder holder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(child.getLayoutNode());
                if (holder != null) {
                    info.addChild(holder);
                } else {
                    info.addChild(this.view, child.getId());
                }
            }
        }
        if (this.focusedVirtualViewId == virtualViewId) {
            info.setAccessibilityFocused(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            info.setAccessibilityFocused(false);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        setStateDescription(semanticsNode, info);
        setIsCheckable(semanticsNode, info);
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleState != null) {
            if (toggleState == ToggleableState.On) {
                info.setChecked(true);
            } else if (toggleState == ToggleableState.Off) {
                info.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (role == null ? false : Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4574getTabo7Vup1c())) {
                info.setSelected(it);
            } else {
                info.setChecked(it);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            infoContentDescriptionOrNull = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(semanticsNode);
            info.setContentDescription(infoContentDescriptionOrNull);
        }
        String testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
        if (testTag != null) {
            boolean testTagsAsResourceId = false;
            SemanticsNode current = semanticsNode;
            while (true) {
                if (current == null) {
                    break;
                }
                if (current.getUnmergedConfig().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    testTagsAsResourceId = ((Boolean) current.getUnmergedConfig().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                }
                current = current.getParent();
            }
            if (testTagsAsResourceId) {
                info.setViewIdResourceName(testTag);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            info.setHeading(true);
            Unit it2 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode);
        info.setPassword(isPassword);
        isTextField2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
        info.setEditable(isTextField2);
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        info.setEnabled(enabled);
        info.setFocusable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i = 2;
        if (info.isFocusable()) {
            info.setFocused(((Boolean) semanticsNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (info.isFocused()) {
                info.addAction(2);
            } else {
                info.addAction(1);
            }
        }
        isVisible = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode);
        info.setVisibleToUser(isVisible);
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int it3 = liveRegionMode.getValue();
            if (LiveRegionMode.m4555equalsimpl0(it3, LiveRegionMode.INSTANCE.m4560getPolite0phEisY())) {
                i = 1;
            } else if (!LiveRegionMode.m4555equalsimpl0(it3, LiveRegionMode.INSTANCE.m4559getAssertive0phEisY())) {
                i = 1;
            }
            info.setLiveRegion(i);
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        }
        info.setClickable(false);
        AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
        if (it4 != null) {
            boolean isSelected = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            info.setClickable(!isSelected);
            enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled8 && !isSelected) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, it4.getLabel()));
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        info.setLongClickable(false);
        AccessibilityAction it5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
        if (it5 != null) {
            info.setLongClickable(true);
            enabled7 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled7) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, it5.getLabel()));
            }
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
        AccessibilityAction it6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
        if (it6 != null) {
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, it6.getLabel()));
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled2) {
            AccessibilityAction it7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
            if (it7 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, it7.getLabel()));
                Unit unit16 = Unit.INSTANCE;
                Unit unit17 = Unit.INSTANCE;
            }
            AccessibilityAction it8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPerformImeAction());
            if (it8 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionImeEnter, it8.getLabel()));
                Unit unit18 = Unit.INSTANCE;
                Unit unit19 = Unit.INSTANCE;
            }
            AccessibilityAction it9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
            if (it9 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, it9.getLabel()));
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
            AccessibilityAction it10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
            if (it10 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, it10.getLabel()));
                }
                Unit unit22 = Unit.INSTANCE;
                Unit unit23 = Unit.INSTANCE;
            }
        }
        String text = getIterableTextForAccessibility(semanticsNode);
        String str = text;
        if (!(str == null || str.length() == 0)) {
            info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction setSelectionAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetSelection());
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, setSelectionAction != null ? setSelectionAction.getLabel() : null));
            info.addAction(256);
            info.addAction(512);
            info.setMovementGranularities(11);
            List contentDescription = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
            List list = contentDescription;
            if ((list == null || list.isEmpty()) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                excludeLineAndPageGranularities = AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode);
                if (!excludeLineAndPageGranularities) {
                    info.setMovementGranularities(16 | info.getMovementGranularities() | 4);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            List extraDataKeys = new ArrayList();
            extraDataKeys.add(ExtraDataIdKey);
            CharSequence text2 = info.getText();
            if (!(text2 == null || text2.length() == 0) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                extraDataKeys.add(ExtraDataTestTagKey);
            }
            AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
            AccessibilityNodeInfo unwrap = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
            accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, extraDataKeys);
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                info.setClassName("android.widget.SeekBar");
            } else {
                info.setClassName("android.widget.ProgressBar");
            }
            if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                enabled6 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled6) {
                    if (rangeInfo.getCurrent() < RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (rangeInfo.getCurrent() > RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfoKt.setCollectionInfo(semanticsNode, info);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode, info);
        ScrollAxisRange xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction scrollAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
        if (xScrollState != null && scrollAction2 != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.HorizontalScrollView");
            }
            if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled5) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl2) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    info.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    info.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange yScrollState2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (yScrollState2 != null && scrollAction2 != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.ScrollView");
            }
            if (yScrollState2.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled4) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(yScrollState2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(yScrollState2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(info, semanticsNode);
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getPaneTitle()));
        enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled3) {
            AccessibilityAction it11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
            if (it11 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, it11.getLabel()));
                Unit unit24 = Unit.INSTANCE;
                Unit unit25 = Unit.INSTANCE;
            }
            AccessibilityAction it12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
            if (it12 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, it12.getLabel()));
                Unit unit26 = Unit.INSTANCE;
                Unit unit27 = Unit.INSTANCE;
            }
            AccessibilityAction it13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
            if (it13 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, it13.getLabel()));
                Unit unit28 = Unit.INSTANCE;
                Unit unit29 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List customActions = (List) semanticsNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                if (customActions.size() >= AccessibilityActionsResourceIds.length) {
                    throw new IllegalStateException("Can't have more than " + AccessibilityActionsResourceIds.length + " custom actions for one widget");
                }
                SparseArrayCompat currentActionIdToLabel = new SparseArrayCompat();
                Map currentLabelToActionId = new LinkedHashMap();
                if (this.labelToActionId.containsKey(virtualViewId)) {
                    Map oldLabelToActionId = this.labelToActionId.get(virtualViewId);
                    List availableIds = ArraysKt.toMutableList(AccessibilityActionsResourceIds);
                    List unassignedActions = new ArrayList();
                    List $this$fastForEach$iv2 = customActions;
                    int size2 = $this$fastForEach$iv2.size();
                    int index$iv2 = 0;
                    while (index$iv2 < size2) {
                        int i2 = size2;
                        List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                        Object item$iv2 = $this$fastForEach$iv3.get(index$iv2);
                        CustomAccessibilityAction action = (CustomAccessibilityAction) item$iv2;
                        Intrinsics.checkNotNull(oldLabelToActionId);
                        ScrollAxisRange xScrollState2 = xScrollState;
                        if (oldLabelToActionId.containsKey(action.getLabel())) {
                            Integer actionId = oldLabelToActionId.get(action.getLabel());
                            Intrinsics.checkNotNull(actionId);
                            scrollAction = scrollAction2;
                            yScrollState = yScrollState2;
                            currentActionIdToLabel.put(actionId.intValue(), action.getLabel());
                            currentLabelToActionId.put(action.getLabel(), actionId);
                            availableIds.remove(actionId);
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId.intValue(), action.getLabel()));
                        } else {
                            scrollAction = scrollAction2;
                            yScrollState = yScrollState2;
                            unassignedActions.add(action);
                        }
                        index$iv2++;
                        size2 = i2;
                        $this$fastForEach$iv2 = $this$fastForEach$iv3;
                        xScrollState = xScrollState2;
                        scrollAction2 = scrollAction;
                        yScrollState2 = yScrollState;
                    }
                    List $this$fastForEachIndexed$iv = unassignedActions;
                    int index$iv3 = 0;
                    int size3 = $this$fastForEachIndexed$iv.size();
                    while (index$iv3 < size3) {
                        Object item$iv3 = $this$fastForEachIndexed$iv.get(index$iv3);
                        CustomAccessibilityAction action2 = (CustomAccessibilityAction) item$iv3;
                        int index = index$iv3;
                        List availableIds2 = availableIds;
                        int actionId2 = availableIds.get(index).intValue();
                        currentActionIdToLabel.put(actionId2, action2.getLabel());
                        currentLabelToActionId.put(action2.getLabel(), Integer.valueOf(actionId2));
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId2, action2.getLabel()));
                        index$iv3++;
                        unassignedActions = unassignedActions;
                        availableIds = availableIds2;
                        $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv;
                    }
                } else {
                    List $this$fastForEachIndexed$iv2 = customActions;
                    int $i$f$fastForEachIndexed = 0;
                    int index$iv4 = 0;
                    int size4 = $this$fastForEachIndexed$iv2.size();
                    while (index$iv4 < size4) {
                        Object item$iv4 = $this$fastForEachIndexed$iv2.get(index$iv4);
                        CustomAccessibilityAction action3 = (CustomAccessibilityAction) item$iv4;
                        int index2 = index$iv4;
                        List customActions2 = customActions;
                        int actionId3 = AccessibilityActionsResourceIds[index2];
                        currentActionIdToLabel.put(actionId3, action3.getLabel());
                        currentLabelToActionId.put(action3.getLabel(), Integer.valueOf(actionId3));
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId3, action3.getLabel()));
                        index$iv4++;
                        $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv2;
                        customActions = customActions2;
                        $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
                    }
                }
                this.actionIdToLabel.put(virtualViewId, currentActionIdToLabel);
                this.labelToActionId.put(virtualViewId, currentLabelToActionId);
            }
        }
        info.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode));
        Integer beforeId = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
        if (beforeId != null) {
            beforeId.intValue();
            View beforeView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), beforeId.intValue());
            if (beforeView != null) {
                info.setTraversalBefore(beforeView);
            } else {
                info.setTraversalBefore(this.view, beforeId.intValue());
            }
            AccessibilityNodeInfo unwrap2 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap2, "info.unwrap()");
            addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, unwrap2, this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL, null);
            Unit unit30 = Unit.INSTANCE;
            Unit unit31 = Unit.INSTANCE;
        }
        Integer afterId = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
        if (afterId != null) {
            afterId.intValue();
            View afterView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), afterId.intValue());
            if (afterView != null) {
                info.setTraversalAfter(afterView);
            } else {
                info.setTraversalAfter(this.view, afterId.intValue());
            }
            AccessibilityNodeInfo unwrap3 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap3, "info.unwrap()");
            addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, unwrap3, this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL, null);
            Unit unit32 = Unit.INSTANCE;
            Unit unit33 = Unit.INSTANCE;
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) {
        Object string;
        Object stateDescription = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                case 1:
                    if ((role == null ? false : Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4573getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.on);
                        break;
                    }
                    break;
                case 2:
                    if ((role == null ? false : Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4573getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.off);
                        break;
                    }
                    break;
                case 3:
                    if (stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.indeterminate);
                        break;
                    }
                    break;
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (!(role == null ? false : Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4574getTabo7Vup1c())) && stateDescription == null) {
                if (it) {
                    string = this.view.getContext().getResources().getString(R.string.selected);
                } else {
                    string = this.view.getContext().getResources().getString(R.string.not_selected);
                }
                stateDescription = string;
            }
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (stateDescription == null) {
                    ClosedFloatingPointRange valueRange = rangeInfo.getRange();
                    float progress = RangesKt.coerceIn(((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) > 0.0f ? 1 : ((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (rangeInfo.getCurrent() - valueRange.getStart().floatValue()) / (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()), 0.0f, 1.0f);
                    if (!(progress == 0.0f)) {
                        percent = progress == 1.0f ? 1 : 0;
                        percent = percent != 0 ? 100 : RangesKt.coerceIn(MathKt.roundToInt(100 * progress), 1, 99);
                    }
                    stateDescription = this.view.getContext().getResources().getString(R.string.template_percent, Integer.valueOf(percent));
                }
            } else if (stateDescription == null) {
                stateDescription = this.view.getContext().getResources().getString(R.string.in_progress);
            }
        }
        return (String) stateDescription;
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription(getInfoStateDescriptionOrNull(node));
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        boolean isCheckable = false;
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            isCheckable = true;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return isCheckable;
        }
        bool.booleanValue();
        if (!(role == null ? false : Role.m4564equalsimpl0(role.getValue(), Role.INSTANCE.m4574getTabo7Vup1c()))) {
            return true;
        }
        return isCheckable;
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final SpannableString getInfoText(SemanticsNode node) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
        SpannableString spannableString = null;
        SpannableString editableTextToAssign = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache) : null, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache);
        }
        SpannableString textToAssign = (SpannableString) trimToSize(spannableString, ParcelSafeTextLength);
        return editableTextToAssign == null ? textToAssign : editableTextToAssign;
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setText(getInfoText(node));
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        if (this.focusedVirtualViewId != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, this.focusedVirtualViewId, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent event = createEvent$ui_release(virtualViewId, eventType);
        if (contentChangeType != null) {
            event.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            event.setContentDescription(TempListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabledForAccessibility()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, event);
    }

    public final AccessibilityEvent createEvent$ui_release(int virtualViewId, int eventType) {
        boolean isPassword;
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        Intrinsics.checkNotNullExpressionValue(event, "obtain(eventType)");
        event.setEnabled(true);
        event.setClassName(ClassName);
        event.setPackageName(this.view.getContext().getPackageName());
        event.setSource(this.view, virtualViewId);
        SemanticsNodeWithAdjustedBounds it = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(virtualViewId));
        if (it != null) {
            isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(it.getSemanticsNode());
            event.setPassword(isPassword);
        }
        return event;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2441 = createEvent$ui_release(virtualViewId, 8192);
        if (fromIndex != null) {
            int it = fromIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2441.setFromIndex(it);
        }
        if (toIndex != null) {
            int it2 = toIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2441.setToIndex(it2);
        }
        if (itemCount != null) {
            int it3 = itemCount.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2441.setItemCount(it3);
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2441.getText().add(text);
        }
        return $this$createTextSelectionChangedEvent_u24lambda_u2441;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (isAccessibilityFocused(virtualViewId)) {
            this.focusedVirtualViewId = Integer.MIN_VALUE;
            this.view.invalidate();
            sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performActionHelper(int r23, int r24, android.os.Bundle r25) {
        /*
            Method dump skipped, instructions count: 1862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds == null || (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String text = getIterableTextForAccessibility(node);
        if (Intrinsics.areEqual(extraDataKey, this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL)) {
            Integer it = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
            if (it != null) {
                info.getExtras().putInt(extraDataKey, it.intValue());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL)) {
            Integer it2 = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
            if (it2 != null) {
                info.getExtras().putInt(extraDataKey, it2.intValue());
                return;
            }
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int positionInfoStartIndex = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int positionInfoLength = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                    ArrayList arrayList = new ArrayList();
                    Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                    Boolean getLayoutResult = function1 != null ? (Boolean) function1.invoke(arrayList) : null;
                    if (Intrinsics.areEqual((Object) getLayoutResult, (Object) true)) {
                        TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                        List boundingRects = new ArrayList();
                        for (int i = 0; i < positionInfoLength; i++) {
                            if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                                boundingRects.add(null);
                            } else {
                                androidx.compose.ui.geometry.Rect bounds = textLayoutResult.getBoundingBox(positionInfoStartIndex + i);
                                RectF boundsOnScreen = toScreenCoords(node, bounds);
                                boundingRects.add(boundsOnScreen);
                            }
                        }
                        List $this$toTypedArray$iv = boundingRects;
                        info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) $this$toTypedArray$iv.toArray(new RectF[0]));
                        return;
                    }
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (testTag != null) {
                info.getExtras().putCharSequence(extraDataKey, testTag);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info.getExtras().putInt(extraDataKey, node.getId());
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        androidx.compose.ui.geometry.Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect boundsInRoot = bounds.m2747translatek4lQ0M(textNode.m4576getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds == null) {
            return null;
        }
        long topLeftInScreen = this.view.mo4148localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
        long bottomRightInScreen = this.view.mo4148localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
        return new RectF(Offset.m2710getXimpl(topLeftInScreen), Offset.m2711getYimpl(topLeftInScreen), Offset.m2710getXimpl(bottomRightInScreen), Offset.m2711getYimpl(bottomRightInScreen));
    }

    public final boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    return handled;
                }
                return true;
            case 8:
            default:
                return false;
            case 10:
                if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    return true;
                }
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
        }
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        boolean isVisible;
        NodeChain nodes;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m4322hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull((List) hitSemanticsEntities);
        LayoutNode layoutNode = node != null ? DelegatableNodeKt.requireLayoutNode(node) : null;
        if (!((layoutNode == null || (nodes = layoutNode.getNodes()) == null || !nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(8))) ? false : true)) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = SemanticsNodeKt.SemanticsNode(layoutNode, false);
        isVisible = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode);
        if (!isVisible) {
            return Integer.MIN_VALUE;
        }
        AndroidViewHolder androidView = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode);
        if (androidView != null) {
            return Integer.MIN_VALUE;
        }
        int virtualViewId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
        return virtualViewId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId == virtualViewId) {
            return;
        }
        int previousVirtualViewId = this.hoveredVirtualViewId;
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, previousVirtualViewId, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (!(size > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i = size;
        if (text != null && text.length() != 0) {
            z = false;
        }
        if (z || text.length() <= size) {
            return text;
        }
        if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
            i = size - 1;
        }
        T t = (T) text.subSequence(0, i);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$45(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Owner.measureAndLayout$default(this$0.view, false, 1, null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:20:0x007c, B:22:0x0084, B:24:0x008d, B:25:0x0090, B:27:0x0096, B:29:0x00a0, B:31:0x00b2, B:33:0x00b9, B:34:0x00c2), top: B:19:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d9 -> B:15:0x0067). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release()) {
            return;
        }
        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo7116trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r0, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode r12, androidx.collection.ArraySet<java.lang.Integer> r13) {
        /*
            r11 = this;
            boolean r0 = r12.isAttached()
            if (r0 != 0) goto L7
            return
        L7:
            androidx.compose.ui.platform.AndroidComposeView r0 = r11.view
            androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
            java.util.HashMap r0 = r0.getLayoutNodeToHolder()
            java.util.Map r0 = (java.util.Map) r0
            boolean r0 = r0.containsKey(r12)
            if (r0 == 0) goto L1a
            return
        L1a:
            r0 = 0
            androidx.compose.ui.node.NodeChain r1 = r12.getNodes()
            r2 = 0
            r3 = 8
            int r2 = androidx.compose.ui.node.NodeKind.m4400constructorimpl(r3)
            boolean r1 = r1.m4363hasH91voCI$ui_release(r2)
            if (r1 == 0) goto L2e
            r1 = r12
            goto L36
        L2e:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r1 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r4) {
                    /*
                        r3 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        androidx.compose.ui.node.NodeChain r0 = r4.getNodes()
                        r1 = 0
                        r2 = 8
                        int r1 = androidx.compose.ui.node.NodeKind.m4400constructorimpl(r2)
                        boolean r0 = r0.m4363hasH91voCI$ui_release(r1)
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        r0 = r2
                        androidx.compose.ui.node.LayoutNode r0 = (androidx.compose.ui.node.LayoutNode) r0
                        java.lang.Boolean r0 = r1.invoke(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r12, r1)
        L36:
            r0 = r1
            if (r0 == 0) goto L7d
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r0.getCollapsedSemantics$ui_release()
            if (r1 != 0) goto L40
            goto L7d
        L40:
            boolean r2 = r1.getIsMergingSemanticsOfDescendants()
            if (r2 != 0) goto L55
        L47:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r2 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        r0 = r2
                        androidx.compose.ui.node.LayoutNode r0 = (androidx.compose.ui.node.LayoutNode) r0
                        java.lang.Boolean r0 = r1.invoke(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r4) {
                    /*
                        r3 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        androidx.compose.ui.semantics.SemanticsConfiguration r0 = r4.getCollapsedSemantics$ui_release()
                        r1 = 0
                        if (r0 == 0) goto L15
                        boolean r0 = r0.getIsMergingSemanticsOfDescendants()
                        r2 = 1
                        if (r0 != r2) goto L15
                        r1 = r2
                    L15:
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }
            }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r0, r2)
            if (r2 == 0) goto L55
        L53:
            r3 = 0
            r0 = r2
        L55:
            if (r0 == 0) goto L7c
            int r2 = r0.getSemanticsId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            boolean r3 = r13.add(r3)
            if (r3 != 0) goto L66
            return
        L66:
            int r5 = r11.semanticsNodeIdToAccessibilityVirtualNodeId(r2)
            r3 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r9 = 8
            r10 = 0
            r6 = 2048(0x800, float:2.87E-42)
            r8 = 0
            r4 = r11
            sendEventForVirtualView$default(r4, r5, r6, r7, r8, r9, r10)
            return
        L7c:
            return
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode, androidx.collection.ArraySet):void");
    }

    private final void checkForSemanticsChanges() {
        sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendContentCaptureSemanticsStructureChangeEvents$ui_release(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes$ui_release());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        boolean hasPaneTitle;
        SemanticsConfiguration unmergedConfig;
        boolean hasPaneTitle2;
        ArraySet toRemove = new ArraySet();
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(id);
            String str = null;
            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (currentNode != null) {
                hasPaneTitle2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(currentNode);
                if (!hasPaneTitle2) {
                }
            }
            toRemove.add(id);
            Intrinsics.checkNotNullExpressionValue(id, "id");
            int intValue = id.intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
            if (semanticsNodeCopy != null && (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) != null) {
                str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
            }
            sendPaneChangeEvents(intValue, 32, str);
        }
        this.paneDisplayed.removeAll((ArraySet<? extends Integer>) toRemove);
        this.previousSemanticsNodes.clear();
        for (Map.Entry entry : getCurrentSemanticsNodes$ui_release().entrySet()) {
            hasPaneTitle = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(entry.getValue().getSemanticsNode());
            if (hasPaneTitle && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(entry.getKey().intValue(), 16, (String) entry.getValue().getSemanticsNode().getUnmergedConfig().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(entry.getValue().getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0429 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03f0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendSemanticsPropertyChangeEvents$ui_release(java.util.Map<java.lang.Integer, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r30) {
        /*
            Method dump skipped, instructions count: 1677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents$ui_release(java.util.Map):void");
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        AutofillId autofillId = session.newAutofillId(id);
        if (autofillId == null) {
            throw new IllegalStateException("Invalid content capture ID".toString());
        }
        session.notifyViewTextChanged(autofillId, newText);
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope scrollObservationScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            scrollObservationScope = oldScope;
        } else {
            newlyObservingScroll = true;
            scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
        }
        ScrollObservationScope newScope = scrollObservationScope;
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (!scrollObservationScope.isValidOwnerScope()) {
            return;
        }
        this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
            
                if ((r7 == 0.0f) == false) goto L21;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke2() {
                /*
                    Method dump skipped, instructions count: 265
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1.invoke2():void");
            }
        });
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentCaptureSessionCompat getContentCaptureSessionCompat(View $this$getContentCaptureSessionCompat) {
        ViewCompatShims.setImportantForContentCapture($this$getContentCaptureSessionCompat, 1);
        return ViewCompatShims.getContentCaptureSession($this$getContentCaptureSessionCompat);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00df, code lost:
    
        r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.m4489toLegacyClassNameV4PA4sw(r2.getValue());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.platform.coreshims.ViewStructureCompat toViewStructure(androidx.compose.ui.semantics.SemanticsNode r25) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.toViewStructure(androidx.compose.ui.semantics.SemanticsNode):androidx.compose.ui.platform.coreshims.ViewStructureCompat");
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        if (viewStructure == null) {
            return;
        }
        if (this.bufferedContentCaptureDisappearedNodes.contains(Integer.valueOf(virtualId))) {
            this.bufferedContentCaptureDisappearedNodes.remove(Integer.valueOf(virtualId));
        } else {
            this.bufferedContentCaptureAppearedNodes.put(Integer.valueOf(virtualId), viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        if (this.bufferedContentCaptureAppearedNodes.containsKey(Integer.valueOf(virtualId))) {
            this.bufferedContentCaptureAppearedNodes.remove(Integer.valueOf(virtualId));
        } else {
            this.bufferedContentCaptureDisappearedNodes.add(Integer.valueOf(virtualId));
        }
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        if (!this.bufferedContentCaptureAppearedNodes.isEmpty()) {
            Collection<ViewStructureCompat> values = this.bufferedContentCaptureAppearedNodes.values();
            Intrinsics.checkNotNullExpressionValue(values, "bufferedContentCaptureAppearedNodes.values");
            List $this$fastMap$iv = CollectionsKt.toList(values);
            List target$iv = new ArrayList($this$fastMap$iv.size());
            int size = $this$fastMap$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                ViewStructureCompat it = (ViewStructureCompat) item$iv$iv;
                target$iv.add(it.toViewStructure());
            }
            session.notifyViewsAppeared(target$iv);
            this.bufferedContentCaptureAppearedNodes.clear();
        }
        if (!this.bufferedContentCaptureDisappearedNodes.isEmpty()) {
            List $this$fastMap$iv2 = CollectionsKt.toList(this.bufferedContentCaptureDisappearedNodes);
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            int size2 = $this$fastMap$iv2.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastMap$iv2.get(index$iv$iv2);
                Integer it2 = (Integer) item$iv$iv2;
                target$iv2.add(Long.valueOf(it2.intValue()));
            }
            session.notifyViewsDisappeared(CollectionsKt.toLongArray(target$iv2));
            this.bufferedContentCaptureDisappearedNodes.clear();
        }
    }

    private final void notifySubtreeAppeared(SemanticsNode node) {
        bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
        List $this$fastForEach$iv = node.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            notifySubtreeAppeared(child);
        }
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Set newChildren = new LinkedHashSet();
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId()))) {
                if (!oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                newChildren.add(Integer.valueOf(child.getId()));
            }
        }
        Iterator<Integer> it = oldNode.getChildren().iterator();
        while (it.hasNext()) {
            if (!newChildren.contains(Integer.valueOf(it.next().intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                return;
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    public final void sendContentCaptureSemanticsStructureChangeEvents$ui_release(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Intrinsics.checkNotNullParameter(newNode, "newNode");
        Intrinsics.checkNotNullParameter(oldNode, "oldNode");
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId())) && !oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                notifySubtreeAppeared(child);
            }
        }
        for (Map.Entry entry : this.previousSemanticsNodes.entrySet()) {
            if (!getCurrentSemanticsNodes$ui_release().containsKey(entry.getKey())) {
                bufferContentCaptureViewDisappeared(entry.getKey().intValue());
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child2.getId())) && this.previousSemanticsNodes.containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendContentCaptureSemanticsStructureChangeEvents$ui_release(child2, semanticsNodeCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionEnd;
        int selectionStart;
        int action;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if ((str == null || str.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            int selectionStart2 = getAccessibilitySelectionStart(node);
            if (selectionStart2 == -1) {
                selectionStart2 = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionStart2;
        } else {
            selectionEnd = forward ? segmentEnd : segmentStart;
            int selectionStart3 = selectionEnd;
            selectionStart = selectionStart3;
        }
        if (forward) {
            action = 256;
        } else {
            action = 512;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId != it.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                event.setFromIndex(it.getFromIndex());
                event.setToIndex(it.getToIndex());
                event.setAction(it.getAction());
                event.setMovementGranularity(it.getGranularity());
                event.getText().add(getIterableTextForAccessibility(it.getNode()));
                sendEvent(event);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        boolean enabled;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node);
            if (enabled) {
                Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
                }
                return false;
            }
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start >= 0 && start == end && end <= text.length()) {
            i = start;
        } else {
            i = -1;
        }
        this.accessibilityCursorPosition = i;
        boolean nonEmptyText = text.length() > 0;
        AccessibilityEvent event = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(text.length()) : null, text);
        sendEvent(event);
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m4726getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m4721getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if (str == null || str.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE;
                Locale locale = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
                iterator = companion.getInstance(locale);
                iterator.initialize(text);
                break;
            case 2:
                AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.INSTANCE;
                Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
                iterator = companion2.getInstance(locale2);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                Boolean getLayoutResult = function1 != null ? (Boolean) function1.invoke(arrayList) : null;
                if (!Intrinsics.areEqual((Object) getLayoutResult, (Object) true)) {
                    return null;
                }
                TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                if (granularity == 4) {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator2 = AccessibilityIterators.LineTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.LineTextSegmentIterator) iterator2).initialize(text, textLayoutResult);
                    iterator = iterator2;
                    break;
                } else {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator3 = AccessibilityIterators.PageTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.PageTextSegmentIterator) iterator3).initialize(text, textLayoutResult, node);
                    iterator = iterator3;
                    break;
                }
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        boolean isTextField;
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(node);
            if (isTextField) {
                AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
                if (textForTextField != null) {
                    return textForTextField.getText();
                }
                return null;
            }
            List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
            if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
                return null;
            }
            return annotatedString.getText();
        }
        return TempListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            AccessibilityAction it;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, it.getLabel()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "setScrollEventDelta", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final void setScrollEventDelta(AccessibilityEvent event, int deltaX, int deltaY) {
            Intrinsics.checkNotNullParameter(event, "event");
            event.setScrollDeltaX(deltaX);
            event.setScrollDeltaY(deltaY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                AccessibilityAction it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (it != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, it.getLabel()));
                }
                AccessibilityAction it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (it2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, it2.getLabel()));
                }
                AccessibilityAction it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, it3.getLabel()));
                }
                AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (it4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, it4.getLabel()));
                }
            }
        }
    }
}
