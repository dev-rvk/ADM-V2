package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.AndroidTextInputServicePlugin;
import androidx.compose.ui.text.input.PlatformTextInput;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;
import androidx.compose.ui.text.input.PlatformTextInputPlugin;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000Î\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001d*\u0002¥\u0001\b\u0001\u0018\u0000 \u0098\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0098\u0003\u0099\u0003B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010ï\u0001\u001a\u0002062\b\u0010Ô\u0001\u001a\u00030ð\u00012\b\u0010ñ\u0001\u001a\u00030¨\u0001J&\u0010ò\u0001\u001a\u0002062\u0007\u0010ó\u0001\u001a\u00020>2\b\u0010ô\u0001\u001a\u00030õ\u00012\b\u0010ö\u0001\u001a\u00030÷\u0001H\u0002J\u0019\u0010%\u001a\u0002062\u000f\u0010ø\u0001\u001a\n\u0012\u0005\u0012\u00030ú\u00010ù\u0001H\u0016J\t\u0010û\u0001\u001a\u00020[H\u0002J\u0013\u0010ü\u0001\u001a\u000206H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010ý\u0001J!\u0010þ\u0001\u001a\u00020t2\u0007\u0010ÿ\u0001\u001a\u00020tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0080\u0002\u0010\u0081\u0002J!\u0010\u0082\u0002\u001a\u00020t2\u0007\u0010\u0083\u0002\u001a\u00020tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u0081\u0002J\u0012\u0010\u0085\u0002\u001a\u00020[2\u0007\u0010\u0086\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0087\u0002\u001a\u00020[2\u0007\u0010\u0086\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0088\u0002\u001a\u0002062\u0007\u0010\u0089\u0002\u001a\u00020\u0001H\u0002J%\u0010\u008a\u0002\u001a\u00030\u008b\u00022\u0007\u0010\u008c\u0002\u001a\u00020>H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002J.\u0010\u008f\u0002\u001a\u00020E2\u0014\u0010\u0090\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0091\u0002\u0012\u0004\u0012\u000206042\r\u0010\u0092\u0002\u001a\b\u0012\u0004\u0012\u0002060HH\u0016J\u0013\u0010\u0093\u0002\u001a\u0002062\b\u0010\u0094\u0002\u001a\u00030\u0095\u0002H\u0014J\u0013\u0010\u0096\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0016J\u0013\u0010\u0098\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0016J\u0013\u0010\u0099\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030\u009a\u0002H\u0016J\u0013\u0010\u009b\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030\u009a\u0002H\u0016J\u0013\u0010\u009c\u0002\u001a\u00020[2\b\u0010\u009d\u0002\u001a\u00030¡\u0001H\u0016J\u001b\u0010\u009e\u0002\u001a\u0002062\b\u0010Ô\u0001\u001a\u00030ð\u00012\b\u0010\u0094\u0002\u001a\u00030\u0095\u0002J\u001f\u0010\u009f\u0002\u001a\u0005\u0018\u00010Õ\u00012\u0007\u0010 \u0002\u001a\u00020>2\b\u0010¡\u0002\u001a\u00030Õ\u0001H\u0002J\u0013\u0010¢\u0002\u001a\u0005\u0018\u00010Õ\u00012\u0007\u0010 \u0002\u001a\u00020>J\u001c\u0010£\u0002\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u00012\u0007\u0010¤\u0002\u001a\u00020[H\u0016J%\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\b\u0010§\u0002\u001a\u00030¨\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u0013\u0010«\u0002\u001a\u0002062\b\u0010¬\u0002\u001a\u00030\u00ad\u0002H\u0016J&\u0010®\u0002\u001a\u00030¯\u00022\b\u0010\u009d\u0002\u001a\u00030¡\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b°\u0002\u0010±\u0002J\u0013\u0010²\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0002J\u001d\u0010³\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u00012\b\u0010´\u0002\u001a\u00030¡\u0001H\u0002J\t\u0010µ\u0002\u001a\u000206H\u0016J\u0013\u0010¶\u0002\u001a\u0002062\b\u0010·\u0002\u001a\u00030¨\u0001H\u0002J\u0013\u0010¸\u0002\u001a\u0002062\b\u0010·\u0002\u001a\u00030¨\u0001H\u0002J\u0013\u0010¹\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0002J\u0013\u0010º\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0002J\u0013\u0010»\u0002\u001a\u00020[2\b\u0010\u009d\u0002\u001a\u00030¡\u0001H\u0002J\u0013\u0010¼\u0002\u001a\u00020[2\b\u0010\u0097\u0002\u001a\u00030¡\u0001H\u0002J!\u0010½\u0002\u001a\u00020t2\u0007\u0010\u0083\u0002\u001a\u00020tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¾\u0002\u0010\u0081\u0002J,\u0010¿\u0002\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u00012\b\u0010À\u0002\u001a\u00030\u0093\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÁ\u0002\u0010Â\u0002J\u0012\u0010¿\u0002\u001a\u0002062\u0007\u0010Ã\u0002\u001a\u00020[H\u0016J\t\u0010Ä\u0002\u001a\u000206H\u0016J!\u0010Å\u0002\u001a\u0002062\u0007\u0010Æ\u0002\u001a\u00020E2\u0007\u0010Ç\u0002\u001a\u00020[H\u0000¢\u0006\u0003\bÈ\u0002J\u0013\u0010É\u0002\u001a\u0002062\b\u0010·\u0002\u001a\u00030¨\u0001H\u0016J\t\u0010Ê\u0002\u001a\u000206H\u0014J\t\u0010Ë\u0002\u001a\u00020[H\u0016J\u0012\u0010Ì\u0002\u001a\u0002062\u0007\u0010Í\u0002\u001a\u000205H\u0014J\u0016\u0010Î\u0002\u001a\u0005\u0018\u00010Ï\u00022\b\u0010Ð\u0002\u001a\u00030Ñ\u0002H\u0016J\u0013\u0010Ò\u0002\u001a\u0002062\b\u0010·\u0002\u001a\u00030¨\u0001H\u0016J\t\u0010Ó\u0002\u001a\u000206H\u0014J\u0013\u0010Ô\u0002\u001a\u0002062\b\u0010\u0094\u0002\u001a\u00030\u0095\u0002H\u0014J\t\u0010Õ\u0002\u001a\u000206H\u0016J'\u0010Ö\u0002\u001a\u0002062\u0007\u0010×\u0002\u001a\u00020[2\u0007\u0010\u0086\u0002\u001a\u00020>2\n\u0010Ø\u0002\u001a\u0005\u0018\u00010\u00ad\u0002H\u0014J6\u0010Ù\u0002\u001a\u0002062\u0007\u0010Ú\u0002\u001a\u00020[2\u0007\u0010Û\u0002\u001a\u00020>2\u0007\u0010Ü\u0002\u001a\u00020>2\u0007\u0010Ý\u0002\u001a\u00020>2\u0007\u0010Þ\u0002\u001a\u00020>H\u0014J\u0013\u0010ß\u0002\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u0001H\u0016J\u001b\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u00020>2\u0007\u0010â\u0002\u001a\u00020>H\u0014J\u001e\u0010ã\u0002\u001a\u0002062\n\u0010ä\u0002\u001a\u0005\u0018\u00010å\u00022\u0007\u0010æ\u0002\u001a\u00020>H\u0016J.\u0010ç\u0002\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u00012\u0007\u0010¤\u0002\u001a\u00020[2\u0007\u0010è\u0002\u001a\u00020[2\u0007\u0010é\u0002\u001a\u00020[H\u0016J%\u0010ê\u0002\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u00012\u0007\u0010¤\u0002\u001a\u00020[2\u0007\u0010è\u0002\u001a\u00020[H\u0016J\u0013\u0010ë\u0002\u001a\u0002062\b\u0010ì\u0002\u001a\u00030í\u0002H\u0016J\u0011\u0010î\u0002\u001a\u0002062\u0006\u0010\u007f\u001a\u00020>H\u0016J\t\u0010ï\u0002\u001a\u000206H\u0016J\u0012\u0010ð\u0002\u001a\u0002062\u0007\u0010ñ\u0002\u001a\u00020[H\u0016J.\u0010ò\u0002\u001a\u00030\u008b\u00022\u0007\u0010ó\u0002\u001a\u00020>2\u0007\u0010Þ\u0002\u001a\u00020>H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bô\u0002\u0010õ\u0002J\t\u0010ö\u0002\u001a\u000206H\u0002J\u0013\u0010ö\u0002\u001a\u0002062\b\u0010\u009d\u0002\u001a\u00030¡\u0001H\u0002J\t\u0010÷\u0002\u001a\u000206H\u0002J\u0018\u0010ø\u0002\u001a\u00020[2\u0007\u0010Æ\u0002\u001a\u00020EH\u0000¢\u0006\u0003\bù\u0002J\u0018\u0010ú\u0002\u001a\u0002062\r\u0010û\u0002\u001a\b\u0012\u0004\u0012\u0002060HH\u0016J\u0013\u0010ü\u0002\u001a\u0002062\b\u0010û\u0002\u001a\u00030ý\u0002H\u0016J\u0011\u0010þ\u0002\u001a\u0002062\b\u0010Ô\u0001\u001a\u00030ð\u0001J\u0007\u0010ÿ\u0002\u001a\u000206J\u0013\u0010\u0080\u0003\u001a\u0002062\b\u0010ñ\u0001\u001a\u00030¨\u0001H\u0016J\u0017\u0010é\u0002\u001a\u0002062\f\b\u0002\u0010\u0081\u0003\u001a\u0005\u0018\u00010¨\u0001H\u0002J!\u0010\u0082\u0003\u001a\u00020t2\u0007\u0010\u0083\u0003\u001a\u00020tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0084\u0003\u0010\u0081\u0002J\"\u0010\u0085\u0003\u001a\u00020[2\b\u0010§\u0002\u001a\u00030¨\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0086\u0003\u0010\u0087\u0003J&\u0010\u0088\u0003\u001a\u00030¯\u00022\b\u0010\u009d\u0002\u001a\u00030¡\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0003\u0010±\u0002J0\u0010\u008a\u0003\u001a\u0002062\b\u0010\u009d\u0002\u001a\u00030¡\u00012\u0007\u0010\u008b\u0003\u001a\u00020>2\u0007\u0010\u008c\u0003\u001a\u00020v2\t\b\u0002\u0010\u008d\u0003\u001a\u00020[H\u0002J\u001c\u0010\u008e\u0003\u001a\u0002062\u0013\u0010\u008f\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010\u0090\u0003\u001a\u00020[H\u0016J\t\u0010\u0091\u0003\u001a\u000206H\u0002J\u000e\u0010\u0092\u0003\u001a\u00020[*\u00030¨\u0001H\u0002J\u001e\u0010\u0093\u0003\u001a\u00020>*\u00030\u008b\u0002H\u0082\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0094\u0003\u0010\u0095\u0003J\u001e\u0010\u0096\u0003\u001a\u00020>*\u00030\u008b\u0002H\u0082\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0097\u0003\u0010\u0095\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020?2\u0006\u0010\u0011\u001a\u00020?@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010H0GX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020JX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR+\u0010N\u001a\u00020M2\u0006\u0010\u0011\u001a\u00020M8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010\u0019\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010T\u001a\u00020U8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010^\u001a\u00020_X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010`R\u0014\u0010a\u001a\u00020bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u000e\u0010h\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\u00020j8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u000e\u0010m\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\u00020[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010gR\u000e\u0010o\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010s\u001a\u00020tX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010`R$\u0010u\u001a\u00020v8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bw\u0010W\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0014\u0010|\u001a\b\u0012\u0004\u0012\u00020E0}X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u007f\u001a\u00020~2\u0006\u0010\u0011\u001a\u00020~8V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u0084\u0001\u0010\u0019\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0089\u0001\u001a\u00020v8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010yR\u0018\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u001d\u0010\u0094\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u009a\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0010\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u009f\u0001\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002060HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¤\u0001\u001a\u00030¥\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¦\u0001R\u0018\u0010§\u0001\u001a\u00030¨\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010«\u0001\u001a\u00030¬\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u000f\u0010¯\u0001\u001a\u00020qX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001a\u00030±\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010²\u0001\u001a\u00030³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010´\u0001\u001a\u00030µ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R\u0010\u0010¸\u0001\u001a\u00030¹\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010º\u0001\u001a\u00030»\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R%\u0010¾\u0001\u001a\u00020[X\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b¿\u0001\u0010W\u001a\u0005\bÀ\u0001\u0010g\"\u0006\bÁ\u0001\u0010Â\u0001R\u0018\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u000f\u0010Ç\u0001\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010È\u0001\u001a\u00030É\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0018\u0010Ì\u0001\u001a\u00030Í\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ò\u0001\u001a\u00030Ó\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ô\u0001\u001a\u00030Õ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÖ\u0001\u0010×\u0001R\u0018\u0010Ø\u0001\u001a\u00030Ù\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u0012\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Þ\u0001\u001a\u00030ß\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010à\u0001R!\u0010á\u0001\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0005\bâ\u0001\u0010\u0015R\u000f\u0010å\u0001\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010æ\u0001\u001a\u00030ç\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010é\u0001R\u001a\u0010ê\u0001\u001a\u00020tX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010`R\u001c\u0010ë\u0001\u001a\u00030ß\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010à\u0001R\u001b\u0010ì\u0001\u001a\u00020>*\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009a\u0003"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "platformTextInputPluginRegistry", "Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;", "getPlatformTextInputPluginRegistry", "()Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", NotificationCompat.CATEGORY_EVENT, "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final WindowInfoImpl _windowInfo;
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private final CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private Density density;
    private final List<OwnedLayer> dirtyLayers;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final TextToolbar textToolbar;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v49, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        CalculateMatrixToWindowApi21 calculateMatrixToWindowApi21;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lastDownPointerPosition = Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope(null, 1, 0 == true ? 1 : 0);
        this.density = AndroidDensity_androidKt.Density(context);
        this.semanticsModifier = EmptySemanticsElement.INSTANCE;
        this.focusOwner = new FocusOwnerImpl(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeView.this.registerOnEndApplyChangesListener(it);
            }
        });
        this._windowInfo = new WindowInfoImpl();
        this.keyInputModifier = KeyInputModifierKt.onKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m4483invokeZmokQxo(keyEvent.m3924unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m4483invokeZmokQxo(android.view.KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FocusDirection focusDirection = AndroidComposeView.this.mo4454getFocusDirectionP8AzH3I(it);
                if (focusDirection == null || !KeyEventType.m3928equalsimpl0(KeyEvent_androidKt.m3936getTypeZmokQxo(it), KeyEventType.INSTANCE.m3932getKeyDownCS__XNY())) {
                    return false;
                }
                return Boolean.valueOf(AndroidComposeView.this.getFocusOwner().mo2647moveFocus3ESFkO8(focusDirection.getValue()));
            }
        });
        this.rotaryInputModifier = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return false;
            }
        });
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.INSTANCE.then(this.semanticsModifier).then(this.rotaryInputModifier).then(getFocusOwner().getModifier()).then(this.keyInputModifier));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        this.accessibilityDelegate = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m3174constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m3174constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m2724getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._viewTreeOwners = mutableStateOf$default;
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.globalLayoutListener$lambda$1(AndroidComposeView.this);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.scrollChangedListener$lambda$2(AndroidComposeView.this);
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.touchModeChangeListener$lambda$3(AndroidComposeView.this, z);
            }
        };
        this.platformTextInputPluginRegistry = new PlatformTextInputPluginRegistryImpl(new Function2<PlatformTextInputPlugin<?>, PlatformTextInput, PlatformTextInputAdapter>() { // from class: androidx.compose.ui.platform.AndroidComposeView$platformTextInputPluginRegistry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.ui.text.input.PlatformTextInputAdapter] */
            @Override // kotlin.jvm.functions.Function2
            public final PlatformTextInputAdapter invoke(PlatformTextInputPlugin<?> factory, PlatformTextInput platformTextInput) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(platformTextInput, "platformTextInput");
                return factory.createAdapter(platformTextInput, AndroidComposeView.this);
            }
        });
        this.textInputService = ((AndroidTextInputServicePlugin.Adapter) getPlatformTextInputPluginRegistry().getOrCreateAdapter(AndroidTextInputServicePlugin.INSTANCE).getAdapter()).getService();
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), null, 2, null);
        this.layoutDirection = mutableStateOf$default2;
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m3618getTouchaOaMEAU() : InputMode.INSTANCE.m3617getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m4482invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m4482invokeiuPiT84(int it) {
                boolean z;
                if (InputMode.m3613equalsimpl0(it, InputMode.INSTANCE.m3618getTouchaOaMEAU())) {
                    z = AndroidComposeView.this.isInTouchMode();
                } else if (InputMode.m3613equalsimpl0(it, InputMode.INSTANCE.m3617getKeyboardaOaMEAU())) {
                    z = AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.coroutineContext = coroutineContext;
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent lastMotionEvent;
                int newAction;
                long j;
                AndroidComposeView.this.removeCallbacks(this);
                lastMotionEvent = AndroidComposeView.this.previousMotionEvent;
                if (lastMotionEvent != null) {
                    boolean z = false;
                    boolean wasMouseEvent = lastMotionEvent.getToolType(0) == 3;
                    int action = lastMotionEvent.getActionMasked();
                    if (wasMouseEvent) {
                        if (action != 10 && action != 1) {
                            z = true;
                        }
                    } else if (action != 1) {
                        z = true;
                    }
                    boolean resend = z;
                    if (resend) {
                        switch (action) {
                            case 7:
                            case 9:
                                newAction = 7;
                                break;
                            case 8:
                            default:
                                newAction = 2;
                                break;
                        }
                        AndroidComposeView androidComposeView = AndroidComposeView.this;
                        j = AndroidComposeView.this.relayoutTime;
                        androidComposeView.sendSimulatedEvent(lastMotionEvent, newAction, j, false);
                    }
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$5(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MotionEvent lastEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                lastEvent = AndroidComposeView.this.previousMotionEvent;
                if (lastEvent != null) {
                    switch (lastEvent.getActionMasked()) {
                        case 7:
                        case 9:
                            AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            androidComposeView$resendMotionEventRunnable$1 = AndroidComposeView.this.resendMotionEventRunnable;
                            androidComposeView.post(androidComposeView$resendMotionEventRunnable$1);
                            return;
                        case 8:
                        default:
                            return;
                    }
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 29) {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi21();
        }
        this.matrixToWindow = calculateMatrixToWindowApi21;
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, this.accessibilityDelegate);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentIcon() {
                return this.currentIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                this.currentIcon = value == null ? PointerIcon.INSTANCE.getDefault() : value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, this.currentIcon);
            }
        };
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this._androidViewsHandler = new AndroidViewsHandler(context);
            addView(this._androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler);
        return androidViewsHandler;
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        State $this$getValue$iv = this._viewTreeOwners;
        return (ViewTreeOwners) $this$getValue$iv.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        MutableState $this$setValue$iv = this._viewTreeOwners;
        $this$setValue$iv.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        State $this$getValue$iv = this.viewTreeOwners;
        return (ViewTreeOwners) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$1(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollChangedListener$lambda$2(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$3(AndroidComposeView this$0, boolean touchMode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputModeManagerImpl inputModeManagerImpl = this$0._inputModeManager;
        InputMode.Companion companion = InputMode.INSTANCE;
        inputModeManagerImpl.m3621setInputModeiuPiT84(touchMode ? companion.m3618getTouchaOaMEAU() : companion.m3617getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.ui.node.Owner
    public PlatformTextInputPluginRegistryImpl getPlatformTextInputPluginRegistry() {
        return this.platformTextInputPluginRegistry;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        MutableState $this$setValue$iv = this.fontFamilyResolver;
        $this$setValue$iv.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        State $this$getValue$iv = this.fontFamilyResolver;
        return (FontFamily.Resolver) $this$getValue$iv.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration $this$fontWeightAdjustmentCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            return $this$fontWeightAdjustmentCompat.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        MutableState $this$setValue$iv = this.layoutDirection;
        $this$setValue$iv.setValue(layoutDirection);
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        State $this$getValue$iv = this.layoutDirection;
        return (LayoutDirection) $this$getValue$iv.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$5(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hoverExitReceived = false;
        MotionEvent lastEvent = this$0.previousMotionEvent;
        Intrinsics.checkNotNull(lastEvent);
        if (!(lastEvent.getActionMasked() == 10)) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        this$0.m4481sendMotionEvent8iAsVTc(lastEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(rect, "rect");
        androidx.compose.ui.geometry.Rect $this$getFocusedRect_u24lambda_u246 = getFocusOwner().getFocusRect();
        if ($this$getFocusedRect_u24lambda_u246 != null) {
            rect.left = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getLeft());
            rect.top = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getTop());
            rect.right = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getRight());
            rect.bottom = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d(FocusTag, "Owner FocusChanged(" + gainFocus + ')');
        FocusOwner focusOwner = getFocusOwner();
        if (gainFocus) {
            focusOwner.takeFocus();
        } else {
            focusOwner.releaseFocus();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean newShowLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && getShowLayoutBounds() != (newShowLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(newShowLayoutBounds);
            invalidateDescendants();
        }
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo4456sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return getFocusOwner().mo2648dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || getFocusOwner().mo2649dispatchKeyEventZmokQxo(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isFocused()) {
            this._windowInfo.m4550setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m4130constructorimpl(event.getMetaState()));
            return getFocusOwner().mo2649dispatchKeyEventZmokQxo(KeyEvent.m3919constructorimpl(event)) || super.dispatchKeyEvent(event);
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return (isFocused() && getFocusOwner().mo2648dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m3919constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onAttach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler childAndroidViews = this._androidViewsHandler;
        if (childAndroidViews != null) {
            clearChildInvalidObservations(childAndroidViews);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                MutableVector this_$iv = this.endApplyChangesListeners;
                Function0<Unit> listener = this_$iv.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (listener != null) {
                    listener.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.endApplyChangesListeners.contains(listener)) {
            MutableVector this_$iv = this.endApplyChangesListeners;
            this_$iv.add(listener);
        }
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof AndroidComposeView) {
                ((AndroidComposeView) child).onEndApplyChanges();
            } else if (child instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        Integer it;
        if (Intrinsics.areEqual(extraDataKey, this.accessibilityDelegate.getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL())) {
            Integer it2 = this.accessibilityDelegate.getIdToBeforeMap$ui_release().get(Integer.valueOf(virtualViewId));
            if (it2 != null) {
                info.getExtras().putInt(extraDataKey, it2.intValue());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.accessibilityDelegate.getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL()) && (it = this.accessibilityDelegate.getIdToAfterMap$ui_release().get(Integer.valueOf(virtualViewId))) != null) {
            info.getExtras().putInt(extraDataKey, it.intValue());
        }
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x003c, code lost:
            
                if (r0.intValue() == r2.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) goto L10;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onInitializeAccessibilityNodeInfo(android.view.View r12, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r13) {
                /*
                    r11 = this;
                    java.lang.String r0 = "host"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                    java.lang.String r0 = "info"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                    super.onInitializeAccessibilityNodeInfo(r12, r13)
                    androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNode.this
                    androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r1 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                        static {
                            /*
                                androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1) androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<init>():void");
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
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
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
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(java.lang.Object):java.lang.Object");
                        }
                    }
                    kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                    androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.findClosestParentNode(r0, r1)
                    if (r0 == 0) goto L26
                L1d:
                    int r0 = r0.getSemanticsId()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    goto L27
                L26:
                    r0 = 0
                L27:
                    if (r0 == 0) goto L3e
                    androidx.compose.ui.platform.AndroidComposeView r1 = r2
                    androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
                    androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
                    int r1 = r1.getId()
                    int r2 = r0.intValue()
                    if (r2 != r1) goto L43
                L3e:
                    r1 = -1
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                L43:
                    androidx.compose.ui.platform.AndroidComposeView r1 = r3
                    android.view.View r1 = (android.view.View) r1
                    int r2 = r0.intValue()
                    r13.setParent(r1, r2)
                    androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.node.LayoutNode.this
                    int r1 = r1.getSemanticsId()
                    androidx.compose.ui.platform.AndroidComposeView r2 = r2
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r2 = androidx.compose.ui.platform.AndroidComposeView.access$getAccessibilityDelegate$p(r2)
                    java.util.HashMap r2 = r2.getIdToBeforeMap$ui_release()
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r2 = r2.get(r3)
                    java.lang.Integer r2 = (java.lang.Integer) r2
                    java.lang.String r3 = "info.unwrap()"
                    if (r2 == 0) goto La5
                    androidx.compose.ui.platform.AndroidComposeView r4 = r2
                    androidx.compose.ui.platform.AndroidComposeView r5 = r3
                    r6 = r2
                    java.lang.Number r6 = (java.lang.Number) r6
                    int r6 = r6.intValue()
                    r7 = 0
                    androidx.compose.ui.platform.AndroidViewsHandler r8 = r4.getAndroidViewsHandler$ui_release()
                    int r9 = r2.intValue()
                    android.view.View r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(r8, r9)
                    if (r8 == 0) goto L8b
                    r13.setTraversalBefore(r8)
                    goto L90
                L8b:
                    android.view.View r5 = (android.view.View) r5
                    r13.setTraversalBefore(r5, r6)
                L90:
                    android.view.accessibility.AccessibilityNodeInfo r5 = r13.unwrap()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r9 = androidx.compose.ui.platform.AndroidComposeView.access$getAccessibilityDelegate$p(r4)
                    java.lang.String r9 = r9.getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r4, r1, r5, r9)
                La5:
                    androidx.compose.ui.platform.AndroidComposeView r4 = r2
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r4 = androidx.compose.ui.platform.AndroidComposeView.access$getAccessibilityDelegate$p(r4)
                    java.util.HashMap r4 = r4.getIdToAfterMap$ui_release()
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r4 = r4.get(r5)
                    java.lang.Integer r4 = (java.lang.Integer) r4
                    if (r4 == 0) goto Lf3
                    androidx.compose.ui.platform.AndroidComposeView r5 = r2
                    androidx.compose.ui.platform.AndroidComposeView r6 = r3
                    r7 = r4
                    java.lang.Number r7 = (java.lang.Number) r7
                    int r7 = r7.intValue()
                    r8 = 0
                    androidx.compose.ui.platform.AndroidViewsHandler r9 = r5.getAndroidViewsHandler$ui_release()
                    int r10 = r4.intValue()
                    android.view.View r9 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(r9, r10)
                    if (r9 == 0) goto Ld9
                    r13.setTraversalAfter(r9)
                    goto Lde
                Ld9:
                    android.view.View r6 = (android.view.View) r6
                    r13.setTraversalAfter(r6, r7)
                Lde:
                    android.view.accessibility.AccessibilityNodeInfo r6 = r13.unwrap()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = androidx.compose.ui.platform.AndroidComposeView.access$getAccessibilityDelegate$p(r5)
                    java.lang.String r3 = r3.getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r5, r1, r6, r3)
                Lf3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        Intrinsics.checkNotNullParameter(view, "view");
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                ViewCompat.setImportantForAccessibility(view, 0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (nodeToRemeasure != null) {
                LayoutNode node = nodeToRemeasure;
                while (node != null && node.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(node)) {
                    node = node.getParent$ui_release();
                }
                if (node == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode $this$childSizeCanAffectParentSize) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = $this$childSizeCanAffectParentSize.getParent$ui_release();
        return parent$ui_release != null && !parent$ui_release.getHasFixedInnerContentConstraints$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0 resend;
        if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() && !this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            return;
        }
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (!sendPointerUpdate) {
            resend = null;
        } else {
            try {
                resend = this.resendMotionEventOnLayout;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        boolean rootNodeResized = this.measureAndLayoutDelegate.measureAndLayout(resend);
        if (rootNodeResized) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
        Unit unit = Unit.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo4455measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m4356measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long $this$component2_u2dVKZWuLQ$iv = m4478convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int minWidth = (int) ULong.m5789constructorimpl($this$component2_u2dVKZWuLQ$iv >>> 32);
            int maxWidth = (int) ULong.m5789constructorimpl($this$component2_u2dVKZWuLQ$iv & 4294967295L);
            try {
                long $this$component2_u2dVKZWuLQ$iv2 = m4478convertMeasureSpecI7RO_PI(heightMeasureSpec);
                int minHeight = (int) ULong.m5789constructorimpl($this$component2_u2dVKZWuLQ$iv2 >>> 32);
                int maxHeight = (int) ULong.m5789constructorimpl(4294967295L & $this$component2_u2dVKZWuLQ$iv2);
                long constraints = ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
                if (this.onMeasureConstraints == null) {
                    this.onMeasureConstraints = Constraints.m5162boximpl(constraints);
                    this.wasMeasuredWithMultipleConstraints = false;
                } else {
                    Constraints constraints2 = this.onMeasureConstraints;
                    if (!(constraints2 != null ? Constraints.m5167equalsimpl0(constraints2.getValue(), constraints) : false)) {
                        this.wasMeasuredWithMultipleConstraints = true;
                    }
                }
                this.measureAndLayoutDelegate.m4357updateRootConstraintsBRTryo0(constraints);
                this.measureAndLayoutDelegate.measureOnly();
                setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
                if (this._androidViewsHandler != null) {
                    getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), BasicMeasure.EXACTLY));
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m4476component1VKZWuLQ(long $this$component1_u2dVKZWuLQ) {
        return (int) ULong.m5789constructorimpl($this$component1_u2dVKZWuLQ >>> 32);
    }

    /* renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m4477component2VKZWuLQ(long $this$component2_u2dVKZWuLQ) {
        return (int) ULong.m5789constructorimpl(4294967295L & $this$component2_u2dVKZWuLQ);
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m4480packZIaKswc(int a, int b) {
        return ULong.m5789constructorimpl(ULong.m5789constructorimpl(ULong.m5789constructorimpl(a) << 32) | ULong.m5789constructorimpl(b));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m4478convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case Integer.MIN_VALUE:
                return m4480packZIaKswc(0, size);
            case 0:
                return m4480packZIaKswc(0, Integer.MAX_VALUE);
            case BasicMeasure.EXACTLY /* 1073741824 */:
                return m4480packZIaKswc(size, size);
            default:
                throw new IllegalStateException();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        boolean positionChanged = false;
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int globalX = IntOffset.m5328component1impl(j);
        int globalY = IntOffset.m5329component2impl(j);
        if (globalX != this.tmpPositionArray[0] || globalY != this.tmpPositionArray[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(this.tmpPositionArray[0], this.tmpPositionArray[1]);
            if (globalX != Integer.MAX_VALUE && globalY != Integer.MAX_VALUE) {
                positionChanged = true;
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(positionChanged);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        ViewLayerContainer viewLayerContainer;
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        OwnedLayer layer = this.layerCache.pop();
        if (layer != null) {
            layer.reuseLayer(drawBlock, invalidateParentLayer);
            return layer;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable th) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.INSTANCE.getHasRetrievedMethod()) {
                ViewLayer.INSTANCE.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLayerContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                viewLayerContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(this.viewLayersContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (this.viewLayersContainer == null || !ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
        }
        if (1 != 0) {
            this.layerCache.push(layer);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo4454getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long m3935getKeyZmokQxo = KeyEvent_androidKt.m3935getKeyZmokQxo(keyEvent);
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3863getTabEK5gGoQ())) {
            return FocusDirection.m2626boximpl(KeyEvent_androidKt.m3941isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m2644getPreviousdhqQ8s() : FocusDirection.INSTANCE.m2642getNextdhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3704getDirectionRightEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2645getRightdhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3703getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2641getLeftdhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3705getDirectionUpEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2646getUpdhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3700getDirectionDownEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2637getDowndhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3699getDirectionCenterEK5gGoQ()) ? true : Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3713getEnterEK5gGoQ()) ? true : Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3805getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2638getEnterdhqQ8s());
        }
        if (Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3642getBackEK5gGoQ()) ? true : Key.m3627equalsimpl0(m3935getKeyZmokQxo, Key.INSTANCE.m3716getEscapeEK5gGoQ())) {
            return FocusDirection.m2626boximpl(FocusDirection.INSTANCE.m2639getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        this.isDrawingContent = true;
        CanvasHolder this_$iv = this.canvasHolder;
        Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        androidx.compose.ui.graphics.Canvas $this$dispatchDraw_u24lambda_u2413 = this_$iv.getAndroidCanvas();
        getRoot().draw$ui_release($this$dispatchDraw_u24lambda_u2413);
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                OwnedLayer layer = this.dirtyLayers.get(i);
                layer.updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int saveCount = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(saveCount);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        if (this.postponedDirtyLayers != null) {
            List postponed = this.postponedDirtyLayers;
            Intrinsics.checkNotNull(postponed);
            this.dirtyLayers.addAll(postponed);
            postponed.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (!isDirty) {
            if (!this.isDrawingContent) {
                this.dirtyLayers.remove(layer);
                List<OwnedLayer> list = this.postponedDirtyLayers;
                if (list != null) {
                    list.remove(layer);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        List it = this.postponedDirtyLayers;
        if (it == null) {
            it = new ArrayList();
            this.postponedDirtyLayers = it;
        }
        it.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(continuation);
        return boundsUpdatesEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayoutNodeMeasurement(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayers(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        AndroidAutofill it;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(it);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners oldViewTreeOwners = getViewTreeOwners();
        boolean resetViewTreeOwner = oldViewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == oldViewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == oldViewTreeOwners.getLifecycleOwner()));
        if (resetViewTreeOwner) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (oldViewTreeOwners != null && (lifecycleOwner = oldViewTreeOwners.getLifecycleOwner()) != null && (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) != null) {
                lifecycleRegistry.removeObserver(this);
            }
            lifecycleOwner2.getLifecycleRegistry().addObserver(this);
            ViewTreeOwners viewTreeOwners = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m3621setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m3618getTouchaOaMEAU() : InputMode.INSTANCE.m3617getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners2);
        viewTreeOwners2.getLifecycleOwner().getLifecycleRegistry().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill it;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) != null) {
            lifecycleRegistry.removeObserver(this);
        }
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(it);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(values, "values");
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 8) {
            if (event.isFromSource(4194304)) {
                return handleRotaryEvent(event);
            }
            if (isBadMotionEvent(event) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(event);
            }
            return ProcessResult.m4155getDispatchedToAPointerInputModifierimpl(m4479handleMotionEvent8iAsVTc(event));
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent lastEvent = this.previousMotionEvent;
            Intrinsics.checkNotNull(lastEvent);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, lastEvent)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int processResult = m4479handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m4154getAnyMovementConsumedimpl(processResult)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m4155getDispatchedToAPointerInputModifierimpl(processResult);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        android.view.ViewConfiguration config = android.view.ViewConfiguration.get(getContext());
        float axisValue = -event.getAxisValue(26);
        RotaryScrollEvent rotaryEvent = new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(config, getContext()) * axisValue, ViewConfigurationCompat.getScaledHorizontalScrollFactor(config, getContext()) * axisValue, event.getEventTime());
        return getFocusOwner().dispatchRotaryEvent(rotaryEvent);
    }

    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m4479handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        boolean z;
        int i;
        MotionEvent lastEvent;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int action = motionEvent.getActionMasked();
                MotionEvent lastEvent2 = this.previousMotionEvent;
                if (lastEvent2 == null || lastEvent2.getToolType(0) != 3) {
                    z = false;
                } else {
                    z = true;
                }
                boolean wasMouseEvent = z;
                if (lastEvent2 == null) {
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (!hasChangedDevices(motionEvent, lastEvent2)) {
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (isDevicePressEvent(lastEvent2)) {
                    this.pointerInputEventProcessor.processCancel();
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (lastEvent2.getActionMasked() != 10 && wasMouseEvent) {
                    i = 3;
                    lastEvent = lastEvent2;
                    sendSimulatedEvent$default(this, lastEvent2, 10, lastEvent2.getEventTime(), false, 8, null);
                } else {
                    i = 3;
                    lastEvent = lastEvent2;
                }
                boolean isMouseEvent = motionEvent.getToolType(0) == i;
                if (!wasMouseEvent && isMouseEvent && action != i && action != 9 && isInBounds(motionEvent)) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (lastEvent != null) {
                    lastEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                return m4481sendMotionEvent8iAsVTc(motionEvent);
            } finally {
                Trace.endSection();
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        if (event.getButtonState() != 0) {
            return true;
        }
        switch (event.getActionMasked()) {
            case 0:
            case 2:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        if (r3 >= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        r5 = (androidx.compose.ui.input.pointer.PointerInputEventData) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r5 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        r1 = r5.m4082getPositionF1C5BW0();
        r8.lastDownPointerPosition = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        r1 = r8.pointerInputEventProcessor.m4087processBIzXfog(r0, r8, isInBounds(r9));
        r2 = r9.getActionMasked();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        if (r2 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        if (r2 != 5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (androidx.compose.ui.input.pointer.ProcessResult.m4155getDispatchedToAPointerInputModifierimpl(r1) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        r8.motionEventAdapter.endStream(r9.getPointerId(r9.getActionIndex()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r3 >= 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        r4 = r3;
        r3 = r3 - 1;
        r5 = r1.get(r4);
        r6 = (androidx.compose.ui.input.pointer.PointerInputEventData) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        if (r6.getDown() == false) goto L12;
     */
    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int m4481sendMotionEvent8iAsVTc(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.keyboardModifiersRequireUpdate
            r1 = 0
            if (r0 == 0) goto L14
            r8.keyboardModifiersRequireUpdate = r1
            androidx.compose.ui.platform.WindowInfoImpl r0 = r8._windowInfo
            int r2 = r9.getMetaState()
            int r2 = androidx.compose.ui.input.pointer.PointerKeyboardModifiers.m4130constructorimpl(r2)
            r0.m4550setKeyboardModifiers5xRPYO0(r2)
        L14:
            androidx.compose.ui.input.pointer.MotionEventAdapter r0 = r8.motionEventAdapter
            r2 = r8
            androidx.compose.ui.input.pointer.PositionCalculator r2 = (androidx.compose.ui.input.pointer.PositionCalculator) r2
            androidx.compose.ui.input.pointer.PointerInputEvent r0 = r0.convertToPointerInputEvent$ui_release(r9, r2)
            if (r0 == 0) goto L7c
            java.util.List r1 = r0.getPointers()
            r2 = 0
            int r3 = r1.size()
            int r3 = r3 + (-1)
            if (r3 < 0) goto L42
        L2e:
            r4 = r3
            int r3 = r3 + (-1)
            java.lang.Object r5 = r1.get(r4)
            r6 = r5
            androidx.compose.ui.input.pointer.PointerInputEventData r6 = (androidx.compose.ui.input.pointer.PointerInputEventData) r6
            r7 = 0
            boolean r6 = r6.getDown()
            if (r6 == 0) goto L40
            goto L43
        L40:
            if (r3 >= 0) goto L2e
        L42:
            r5 = 0
        L43:
            androidx.compose.ui.input.pointer.PointerInputEventData r5 = (androidx.compose.ui.input.pointer.PointerInputEventData) r5
            if (r5 == 0) goto L50
            long r1 = r5.m4082getPositionF1C5BW0()
            r3 = 0
            r8.lastDownPointerPosition = r1
        L50:
            androidx.compose.ui.input.pointer.PointerInputEventProcessor r1 = r8.pointerInputEventProcessor
            r2 = r8
            androidx.compose.ui.input.pointer.PositionCalculator r2 = (androidx.compose.ui.input.pointer.PositionCalculator) r2
            boolean r3 = r8.isInBounds(r9)
            int r1 = r1.m4087processBIzXfog(r0, r2, r3)
            int r2 = r9.getActionMasked()
            if (r2 == 0) goto L67
            r3 = 5
            if (r2 != r3) goto L7a
        L67:
            boolean r3 = androidx.compose.ui.input.pointer.ProcessResult.m4155getDispatchedToAPointerInputModifierimpl(r1)
            if (r3 != 0) goto L7a
            androidx.compose.ui.input.pointer.MotionEventAdapter r3 = r8.motionEventAdapter
            int r4 = r9.getActionIndex()
            int r4 = r9.getPointerId(r4)
            r3.endStream(r4)
        L7a:
            goto L87
        L7c:
            androidx.compose.ui.input.pointer.PointerInputEventProcessor r2 = r8.pointerInputEventProcessor
            r2.processCancel()
            int r1 = androidx.compose.ui.input.pointer.PointerInputEventProcessorKt.ProcessResult(r1, r1)
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m4481sendMotionEvent8iAsVTc(android.view.MotionEvent):int");
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        long downTime;
        int i = -1;
        switch (motionEvent.getActionMasked()) {
            case 1:
                switch (action) {
                    case 9:
                    case 10:
                        break;
                    default:
                        i = 0;
                        break;
                }
            case 6:
                i = motionEvent.getActionIndex();
                break;
        }
        int upIndex = i;
        int pointerCount = motionEvent.getPointerCount() - (upIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerProperties = new MotionEvent.PointerProperties[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerProperties[i2] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoords = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerCoords[i3] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int sourceIndex = ((upIndex < 0 || i4 < upIndex) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(sourceIndex, pointerProperties[i4]);
            MotionEvent.PointerCoords coords = pointerCoords[i4];
            motionEvent.getPointerCoords(sourceIndex, coords);
            long localPosition = OffsetKt.Offset(coords.x, coords.y);
            long screenPosition = mo4148localToScreenMKHz9U(localPosition);
            coords.x = Offset.m2710getXimpl(screenPosition);
            coords.y = Offset.m2711getYimpl(screenPosition);
            i4++;
        }
        int buttonState = forceHover ? 0 : motionEvent.getButtonState();
        if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
            downTime = eventTime;
        } else {
            downTime = motionEvent.getDownTime();
        }
        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerProperties, pointerCoords, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        Intrinsics.checkNotNullExpressionValue(event, "event");
        PointerInputEvent pointerInputEvent = motionEventAdapter.convertToPointerInputEvent$ui_release(event, this);
        Intrinsics.checkNotNull(pointerInputEvent);
        this.pointerInputEventProcessor.m4087processBIzXfog(pointerInputEvent, this, true);
        event.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.accessibilityDelegate.m4486canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.accessibilityDelegate.m4486canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo4148localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long local = Matrix.m3180mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m2710getXimpl(local) + Offset.m2710getXimpl(this.windowPosition), Offset.m2711getYimpl(local) + Offset.m2711getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo4149screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        float x = Offset.m2710getXimpl(positionOnScreen) - Offset.m2710getXimpl(this.windowPosition);
        float y = Offset.m2711getYimpl(positionOnScreen) - Offset.m2711getYimpl(this.windowPosition);
        return Matrix.m3180mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(x, y));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long animationTime = AnimationUtils.currentAnimationTimeMillis();
            if (animationTime != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = animationTime;
                recalculateWindowViewTransforms();
                ViewParent viewParent = getParent();
                AndroidComposeView view = this;
                while (viewParent instanceof ViewGroup) {
                    view = (View) viewParent;
                    viewParent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                float screenX = this.tmpPositionArray[0];
                float screenY = this.tmpPositionArray[1];
                view.getLocationInWindow(this.tmpPositionArray);
                float windowX = this.tmpPositionArray[0];
                float windowY = this.tmpPositionArray[1];
                this.windowPosition = OffsetKt.Offset(screenX - windowX, screenY - windowY);
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long positionInWindow = Matrix.m3180mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m2710getXimpl(positionInWindow), motionEvent.getRawY() - Offset.m2711getYimpl(positionInWindow));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo4493calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m4517invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return getPlatformTextInputPluginRegistry().getFocusedAdapter() != null;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        PlatformTextInputAdapter focusedAdapter = getPlatformTextInputPluginRegistry().getFocusedAdapter();
        if (focusedAdapter != null) {
            return focusedAdapter.createInputConnection(outAttrs);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo4452calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m3180mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo4453calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m3180mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        LayoutDirection it;
        if (this.superclassInitComplete) {
            it = AndroidComposeView_androidKt.layoutDirectionFromInt(layoutDirection);
            setLayoutDirection(it);
            getFocusOwner().setLayoutDirection(it);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.accessibilityDelegate.dispatchHoverEvent(event);
        switch (event.getActionMasked()) {
            case 7:
                if (!isPositionChanged(event)) {
                    return false;
                }
                break;
            case 10:
                if (isInBounds(event)) {
                    if (event.getToolType(0) != 3) {
                        MotionEvent motionEvent = this.previousMotionEvent;
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                        this.hoverExitReceived = true;
                        post(this.sendHoverExitEvent);
                        return false;
                    }
                    if (event.getButtonState() != 0) {
                        return false;
                    }
                }
                break;
        }
        int result = m4479handleMotionEvent8iAsVTc(event);
        return ProcessResult.m4155getDispatchedToAPointerInputModifierimpl(result);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa A[LOOP:0: B:28:0x0062->B:50:0x00aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[EDGE_INSN: B:51:0x00ad->B:58:0x00ad BREAK  A[LOOP:0: B:28:0x0062->B:50:0x00aa], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isBadMotionEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L14
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L14
            r0 = r2
            goto L15
        L14:
            r0 = r3
        L15:
            if (r0 == 0) goto L59
            float r0 = r8.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L29
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L29
            r0 = r2
            goto L2a
        L29:
            r0 = r3
        L2a:
            if (r0 == 0) goto L59
            float r0 = r8.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L3e
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L3e
            r0 = r2
            goto L3f
        L3e:
            r0 = r3
        L3f:
            if (r0 == 0) goto L59
            float r0 = r8.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L53
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L53
            r0 = r2
            goto L54
        L53:
            r0 = r3
        L54:
            if (r0 != 0) goto L57
            goto L59
        L57:
            r0 = r3
            goto L5a
        L59:
            r0 = r2
        L5a:
            if (r0 != 0) goto Lad
            r1 = 1
            int r4 = r8.getPointerCount()
        L62:
            if (r1 >= r4) goto Lad
            float r5 = r8.getX(r1)
            boolean r6 = java.lang.Float.isInfinite(r5)
            if (r6 != 0) goto L76
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L76
            r5 = r2
            goto L77
        L76:
            r5 = r3
        L77:
            if (r5 == 0) goto La6
            float r5 = r8.getY(r1)
            boolean r6 = java.lang.Float.isInfinite(r5)
            if (r6 != 0) goto L8b
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L8b
            r5 = r2
            goto L8c
        L8b:
            r5 = r3
        L8c:
            if (r5 == 0) goto La6
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r5 < r6) goto La0
            androidx.compose.ui.platform.MotionEventVerifierApi29 r5 = androidx.compose.ui.platform.MotionEventVerifierApi29.INSTANCE
            boolean r5 = r5.isValidMotionEvent(r8, r1)
            if (r5 != 0) goto L9e
            r5 = r2
            goto La1
        L9e:
            r5 = r3
            goto La1
        La0:
            r5 = r3
        La1:
            if (r5 == 0) goto La4
            goto La6
        La4:
            r5 = r3
            goto La7
        La6:
            r5 = r2
        La7:
            r0 = r5
            if (r0 != 0) goto Lad
            int r1 = r1 + 1
            goto L62
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isBadMotionEvent(android.view.MotionEvent):boolean");
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent lastEvent;
        if (event.getPointerCount() != 1 || (lastEvent = this.previousMotionEvent) == null || lastEvent.getPointerCount() != event.getPointerCount()) {
            return true;
        }
        if (event.getRawX() == lastEvent.getRawX()) {
            return !((event.getRawY() > lastEvent.getRawY() ? 1 : (event.getRawY() == lastEvent.getRawY() ? 0 : -1)) == 0);
        }
        return true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT < 29) {
            Method getAccessibilityViewIdMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            getAccessibilityViewIdMethod.setAccessible(true);
            if (Intrinsics.areEqual(getAccessibilityViewIdMethod.invoke(currentView, new Object[0]), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                int childCount = ((ViewGroup) currentView).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = ((ViewGroup) currentView).getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
                    View foundView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, childAt);
                    if (foundView != null) {
                        return foundView;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method findViewByAccessibilityIdTraversalMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                findViewByAccessibilityIdTraversalMethod.setAccessible(true);
                Object invoke = findViewByAccessibilityIdTraversalMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    return (View) invoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) == null) ? null : lifecycleRegistry.getState()) == Lifecycle.State.RESUMED;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
