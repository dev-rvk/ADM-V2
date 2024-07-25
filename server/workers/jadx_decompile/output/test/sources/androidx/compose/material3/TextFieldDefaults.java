package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010'J¦\u0002\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010;J7\u0010<\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010'JS\u0010=\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u009c\u0002\u0010B\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010CJî\u0001\u0010B\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010DJ¦\u0002\u0010E\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010;Jø\u0001\u0010E\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010FJÃ\u0003\u0010%\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\b\b\u0002\u0010L\u001a\u00020H2\b\b\u0002\u0010M\u001a\u00020H2\b\b\u0002\u0010N\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010uJ;\u0010v\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010|J;\u0010}\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b~\u0010|J\u0086\u0003\u0010\u007f\u001a\u00020&2\t\b\u0002\u0010\u0080\u0001\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\t\b\u0002\u0010\u0081\u0001\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\t\b\u0002\u0010\u0082\u0001\u001a\u00020H2\t\b\u0002\u0010\u0083\u0001\u001a\u00020H2\t\b\u0002\u0010\u0084\u0001\u001a\u00020H2\t\b\u0002\u0010\u0085\u0001\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\t\b\u0002\u0010\u0086\u0001\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J¶\u0003\u0010\u007f\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\t\b\u0002\u0010\u0081\u0001\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\t\b\u0002\u0010\u0082\u0001\u001a\u00020H2\t\b\u0002\u0010\u0083\u0001\u001a\u00020H2\t\b\u0002\u0010\u0084\u0001\u001a\u00020H2\t\b\u0002\u0010\u0085\u0001\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J?\u0010\u008b\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u008c\u0001\u0010|J?\u0010\u008d\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u008e\u0001\u0010|J\u0083\u0003\u0010\u008f\u0001\u001a\u00020&2\t\b\u0002\u0010\u0080\u0001\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\t\b\u0002\u0010\u0081\u0001\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\t\b\u0002\u0010\u0086\u0001\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u0088\u0001J³\u0003\u0010\u008f\u0001\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\t\b\u0002\u0010\u0081\u0001\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u008a\u0001J?\u0010\u0092\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0093\u0001\u0010|J?\u0010\u0094\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0095\u0001\u0010|JT\u0010\u0096\u0001\u001a\u00030\u0097\u0001*\u00030\u0097\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001c\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009c\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "FilledContainerBox", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldColors", "textColor", "containerColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "placeholderColor", "outlinedTextFieldColors-eS1Emto", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-M37tBTI", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "textFieldColors-eS1Emto", "textFieldColors-M37tBTI", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m5218constructorimpl(56);
    private static final float MinWidth = Dp.m5218constructorimpl(280);
    private static final float UnfocusedIndicatorThickness = Dp.m5218constructorimpl(1);
    private static final float FocusedIndicatorThickness = Dp.m5218constructorimpl(2);
    private static final float UnfocusedBorderThickness = UnfocusedIndicatorThickness;
    private static final float FocusedBorderThickness = FocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations */
    public static /* synthetic */ void m1834getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations */
    public static /* synthetic */ void m1835getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1941327459);
        ComposerKt.sourceInformation($composer, "C57@2544L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:57)");
        }
        Shape shape = ShapesKt.toShape(FilledTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getMinHeight-D9Ej5fM */
    public final float m1847getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM */
    public final float m1848getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM */
    public final float m1850getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM */
    public final float m1846getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ContainerBox(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, final androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI$default */
    public static /* synthetic */ Modifier m1836indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedIndicatorThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedIndicatorThickness;
        }
        return textFieldDefaults.m1851indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* renamed from: indicatorLine-gv0btCI */
    public final Modifier m1851indicatorLinegv0btCI(Modifier indicatorLine, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        Intrinsics.checkNotNullParameter(indicatorLine, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", Dp.m5216boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", Dp.m5216boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                State stroke;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-891038934);
                ComposerKt.sourceInformation($composer, "C140@6028L217:TextFieldDefaults.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, $changed, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:139)");
                }
                stroke = TextFieldDefaultsKt.m1861animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return drawIndicatorLine;
            }
        });
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1832contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m1843contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4 */
    public final PaddingValues m1843contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m480PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1833contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1844contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4 */
    public final PaddingValues m1844contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m480PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default */
    public static /* synthetic */ PaddingValues m1838supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5218constructorimpl(0);
        }
        return textFieldDefaults.m1855supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release */
    public final PaddingValues m1855supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m480PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: colors-0hiis_0 */
    public final TextFieldColors m1842colors0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long focusedContainerColor2;
        long unfocusedContainerColor2;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(1513344955);
        ComposerKt.sourceInformation($composer, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)247@12192L9,248@12272L9,249@12359L9,251@12510L9,252@12597L9,253@12686L9,254@12774L9,255@12859L9,256@12932L9,257@13020L9,258@13103L7,259@13199L9,260@13294L9,261@13396L9,263@13572L9,264@13668L9,265@13761L9,266@13861L9,268@14031L9,269@14129L9,270@14224L9,271@14326L9,273@14499L9,274@14583L9,275@14664L9,276@14752L9,278@14904L9,279@15000L9,280@15098L9,281@15192L9,283@15356L9,284@15454L9,285@15549L9,286@15651L9,288@15822L9,289@15908L9,290@15996L9,291@16083L9,293@16237L9,294@16323L9,295@16411L9,296@16498L9,298@16652L9:TextFieldDefaults.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusInputColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            disabledTextColor2 = disabledTextColor;
        } else {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorInputColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            focusedContainerColor2 = focusedContainerColor;
        } else {
            focusedContainerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            unfocusedContainerColor2 = unfocusedContainerColor;
        } else {
            unfocusedContainerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 2048) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 4096) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c8;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 16384) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((65536 & i) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((262144 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((1048576 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((4194304 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((8388608 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((16777216 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((33554432 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((67108864 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((134217728 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((536870912 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((i2 & 1) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((i2 & 4) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((i2 & 8) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((i2 & 16) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 32) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 64) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 128) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 256) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 512) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 1024) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 2048) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1513344955, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:246)");
        }
        TextFieldColors textFieldColors = new TextFieldColors(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return textFieldColors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01f3, code lost:
    
        if (r8.changed(r133) == false) goto L443;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DecorationBox(final java.lang.String r119, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r120, final boolean r121, final boolean r122, final androidx.compose.ui.text.input.VisualTransformation r123, final androidx.compose.foundation.interaction.InteractionSource r124, boolean r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, androidx.compose.ui.graphics.Shape r133, androidx.compose.material3.TextFieldColors r134, androidx.compose.foundation.layout.PaddingValues r135, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r136, androidx.compose.runtime.Composer r137, final int r138, final int r139, final int r140) {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-584749279);
        ComposerKt.sourceInformation($composer, "C465@26096L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:465)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(611926497);
        ComposerKt.sourceInformation($composer, "C472@26334L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:472)");
        }
        Shape shape = getShape($composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM */
    public final float m1849getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM */
    public final float m1845getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0152  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.ContainerBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n    )", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void FilledContainerBox(final boolean r20, final boolean r21, final androidx.compose.foundation.interaction.InteractionSource r22, final androidx.compose.material3.TextFieldColors r23, androidx.compose.ui.graphics.Shape r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.FilledContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.ContainerBox`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n        focusedBorderThickness = focusedBorderThickness,\n        unfocusedBorderThickness = unfocusedBorderThickness,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: OutlinedBorderContainerBox-nbWgWpA */
    public final void m1841OutlinedBorderContainerBoxnbWgWpA(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        Shape shape3;
        Shape shape4;
        float focusedBorderThickness3;
        float unfocusedBorderThickness2;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer $composer2 = $composer.startRestartGroup(-1998946250);
        ComposerKt.sourceInformation($composer2, "C(OutlinedBorderContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)538@28994L9,541@29216L286:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            } else {
                shape2 = shape;
            }
            i2 = 8192;
            $dirty2 |= i2;
        } else {
            shape2 = shape;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            focusedBorderThickness2 = focusedBorderThickness;
        } else if (($changed & 458752) == 0) {
            focusedBorderThickness2 = focusedBorderThickness;
            $dirty2 |= $composer2.changed(focusedBorderThickness2) ? 131072 : 65536;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            f = unfocusedBorderThickness;
        } else if (($changed & 3670016) == 0) {
            f = unfocusedBorderThickness;
            $dirty2 |= $composer2.changed(f) ? 1048576 : 524288;
        } else {
            f = unfocusedBorderThickness;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
            focusedBorderThickness3 = focusedBorderThickness2;
            unfocusedBorderThickness2 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 16) != 0) {
                    shape3 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape3 = shape2;
                }
                if (i3 != 0) {
                    focusedBorderThickness2 = OutlinedTextFieldDefaults.INSTANCE.m1639getFocusedBorderThicknessD9Ej5fM();
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    shape4 = shape3;
                    unfocusedBorderThickness2 = OutlinedTextFieldDefaults.INSTANCE.m1642getUnfocusedBorderThicknessD9Ej5fM();
                    focusedBorderThickness3 = focusedBorderThickness2;
                } else {
                    shape4 = shape3;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                shape4 = shape2;
                focusedBorderThickness3 = focusedBorderThickness2;
                unfocusedBorderThickness2 = f;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998946250, $dirty, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:533)");
            }
            OutlinedTextFieldDefaults.INSTANCE.m1636ContainerBoxnbWgWpA(enabled, isError, interactionSource, colors, shape4, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Shape shape5 = shape4;
        final float f2 = focusedBorderThickness3;
        final float f3 = unfocusedBorderThickness2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedBorderContainerBox$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                TextFieldDefaults.this.m1841OutlinedBorderContainerBoxnbWgWpA(enabled, isError, interactionSource, colors, shape5, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1839textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m1858textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithLabelPadding-a9UjIt4 */
    public final PaddingValues m1858textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m1843contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1840textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1859textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4 */
    public final PaddingValues m1859textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m1844contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1837outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1854outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldPadding-a9UjIt4 */
    public final PaddingValues m1854outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m1638contentPaddinga9UjIt4(start, top, end, bottom);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.colors` with additional parameters to controlcontainer color based on state.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedIndicatorColor = focusedIndicatorColor,\n        unfocusedIndicatorColor = unfocusedIndicatorColor,\n        disabledIndicatorColor = disabledIndicatorColor,\n        errorIndicatorColor = errorIndicatorColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {}))
    /* renamed from: textFieldColors-M37tBTI */
    public final TextFieldColors m1856textFieldColorsM37tBTI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long containerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(568209592);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)671@35322L9,672@35402L9,673@35489L9,675@35640L9,676@35720L9,677@35805L9,678@35878L9,679@35966L9,680@36049L7,681@36145L9,682@36240L9,683@36342L9,685@36518L9,686@36614L9,687@36707L9,688@36807L9,690@36977L9,691@37075L9,692@37170L9,693@37272L9,695@37445L9,696@37529L9,697@37610L9,698@37698L9,700@37850L9,701@37946L9,702@38044L9,703@38138L9,705@38302L9,706@38400L9,707@38495L9,708@38597L9,710@38768L9,711@38854L9,712@38942L9,713@39029L9,715@39183L9,716@39269L9,717@39357L9,718@39444L9,720@39598L9,721@39634L2308:TextFieldDefaults.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusInputColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorInputColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 512) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 1024) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 2048) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c8;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 4096) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 8192) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((32768 & i) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((65536 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((524288 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((1048576 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((8388608 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((16777216 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((67108864 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((134217728 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((268435456 & i) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((i2 & 1) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((i2 & 2) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 8) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 16) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 32) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 64) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 128) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 512) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(568209592, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:670)");
        }
        TextFieldColors m1842colors0hiis_0 = m1842colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), (($changed3 >> 24) & 14) | (($changed3 >> 24) & 112) | (($changed4 << 6) & 896) | (($changed4 << 6) & 7168), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1842colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.colors` with additional parameters tocontrol container color based on state.", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedBorderColor = focusedBorderColor,\n        unfocusedBorderColor = unfocusedBorderColor,\n        disabledBorderColor = disabledBorderColor,\n        errorBorderColor = errorBorderColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldColors-M37tBTI */
    public final TextFieldColors m1852outlinedTextFieldColorsM37tBTI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long containerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(618732090);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,13:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)821@45523L9,822@45605L9,823@45694L9,825@45849L9,828@46031L9,829@46121L9,830@46204L7,831@46291L9,832@46377L9,833@46470L9,835@46631L9,836@46729L9,837@46824L9,838@46926L9,840@47100L9,841@47200L9,842@47297L9,844@47414L9,845@47578L9,846@47664L9,847@47747L9,848@47837L9,850@47993L9,851@48091L9,852@48191L9,853@48287L9,855@48455L9,856@48555L9,857@48652L9,859@48769L9,860@48931L9,861@49019L9,862@49109L9,863@49198L9,865@49356L9,866@49444L9,867@49534L9,868@49623L9,870@49781L9,871@49843L2284:TextFieldDefaults.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusInputColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorInputColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 32) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 64) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 512) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 1024) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), $composer, 6);
        }
        if ((i & 2048) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c8;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 4096) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), $composer, 6);
        }
        if ((i & 8192) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((32768 & i) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((65536 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((524288 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((1048576 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((8388608 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((16777216 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((67108864 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((134217728 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((268435456 & i) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((i2 & 1) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((i2 & 2) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 8) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 16) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 32) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 64) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 128) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 512) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618732090, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:820)");
        }
        TextFieldColors m1637colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), (($changed3 >> 24) & 14) | 3072 | (($changed3 >> 24) & 112) | (($changed4 << 6) & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1637colors0hiis_0;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        shape = shape,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void TextFieldDecorationBox(final java.lang.String r119, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r120, final boolean r121, final boolean r122, final androidx.compose.ui.text.input.VisualTransformation r123, final androidx.compose.foundation.interaction.InteractionSource r124, boolean r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, androidx.compose.ui.graphics.Shape r133, androidx.compose.material3.TextFieldColors r134, androidx.compose.foundation.layout.PaddingValues r135, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r136, androidx.compose.runtime.Composer r137, final int r138, final int r139, final int r140) {
        /*
            Method dump skipped, instructions count: 1369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e0  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "OutlinedTextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OutlinedTextFieldDecorationBox(final java.lang.String r117, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r118, final boolean r119, final boolean r120, final androidx.compose.ui.text.input.VisualTransformation r121, final androidx.compose.foundation.interaction.InteractionSource r122, boolean r123, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r124, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r133, androidx.compose.runtime.Composer r134, final int r135, final int r136, final int r137) {
        /*
            Method dump skipped, instructions count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-eS1Emto */
    public final /* synthetic */ TextFieldColors m1857textFieldColorseS1Emto(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        long containerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(-595874869);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1060@58072L9,1061@58159L9,1063@58309L9,1064@58382L9,1065@58470L9,1066@58553L7,1067@58649L9,1068@58744L9,1069@58846L9,1071@59022L9,1072@59118L9,1073@59211L9,1074@59311L9,1076@59481L9,1077@59579L9,1078@59674L9,1079@59776L9,1081@59949L9,1082@60033L9,1083@60114L9,1084@60202L9,1086@60354L9,1087@60443L9,1088@60537L9,1090@60705L9,1091@60800L9,1092@60902L9,1094@61073L9,1095@61159L9,1096@61247L9,1097@61334L9,1099@61488L9,1100@61574L9,1101@61662L9,1102@61749L9,1104@61903L9,1105@61939L2261:TextFieldDefaults.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 64) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 128) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c8;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 512) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((i & 4096) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 8192) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((65536 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((131072 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((1048576 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((2097152 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            placeholderColor2 = placeholderColor;
        } else {
            placeholderColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((8388608 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((16777216 & i) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((67108864 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((134217728 & i) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 1) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 16) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-595874869, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:1059)");
        }
        TextFieldColors m1842colors0hiis_0 = m1842colors0hiis_0(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 >> 9) & 112) | (($changed2 >> 9) & 896) | (($changed2 >> 9) & 7168) | (($changed2 >> 9) & 57344) | (($changed2 >> 9) & 458752) | (($changed2 >> 9) & 3670016) | (($changed3 << 21) & 29360128) | (($changed3 << 21) & 234881024) | (($changed3 << 21) & 1879048192), (($changed3 >> 9) & 14) | (($changed3 >> 9) & 112) | (($changed3 >> 9) & 896) | (($changed3 >> 9) & 7168), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1842colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-eS1Emto */
    public final /* synthetic */ TextFieldColors m1853outlinedTextFieldColorseS1Emto(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        long containerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(1767818445);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1155@64431L9,1156@64520L9,1159@64718L9,1160@64808L9,1161@64891L7,1162@64978L9,1163@65064L9,1164@65157L9,1166@65318L9,1167@65416L9,1168@65511L9,1169@65613L9,1171@65787L9,1172@65887L9,1173@65984L9,1175@66101L9,1176@66265L9,1177@66351L9,1178@66434L9,1179@66524L9,1181@66680L9,1182@66771L9,1183@66867L9,1185@67039L9,1186@67136L9,1188@67253L9,1189@67415L9,1190@67503L9,1191@67593L9,1192@67682L9,1194@67840L9,1195@67928L9,1196@68018L9,1197@68107L9,1199@68265L9,1200@68327L2237:TextFieldDefaults.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 8) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 64) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 128) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), $composer, 6);
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c8;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 512) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((i & 4096) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 8192) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((65536 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((131072 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((1048576 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((2097152 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            placeholderColor2 = placeholderColor;
        } else {
            placeholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((8388608 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((16777216 & i) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((67108864 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((134217728 & i) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 1) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 16) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767818445, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:1154)");
        }
        TextFieldColors m1637colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 >> 9) & 112) | (($changed2 >> 9) & 896) | (($changed2 >> 9) & 7168) | (($changed2 >> 9) & 57344) | (($changed2 >> 9) & 458752) | (($changed2 >> 9) & 3670016) | (($changed3 << 21) & 29360128) | (($changed3 << 21) & 234881024) | (($changed3 << 21) & 1879048192), (($changed3 >> 9) & 14) | 3072 | (($changed3 >> 9) & 112) | (($changed3 >> 9) & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1637colors0hiis_0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01d6, code lost:
    
        if (r6.changed(r131) == false) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01f0, code lost:
    
        if (r6.changed(r132) == false) goto L414;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0419  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void TextFieldDecorationBox(final java.lang.String r118, final kotlin.jvm.functions.Function2 r119, final boolean r120, final boolean r121, final androidx.compose.ui.text.input.VisualTransformation r122, final androidx.compose.foundation.interaction.InteractionSource r123, boolean r124, kotlin.jvm.functions.Function2 r125, kotlin.jvm.functions.Function2 r126, kotlin.jvm.functions.Function2 r127, kotlin.jvm.functions.Function2 r128, kotlin.jvm.functions.Function2 r129, androidx.compose.ui.graphics.Shape r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2 r133, androidx.compose.runtime.Composer r134, final int r135, final int r136, final int r137) {
        /*
            Method dump skipped, instructions count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x01bc, code lost:
    
        if (r6.changed(r127) == false) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01d6, code lost:
    
        if (r6.changed(r128) == false) goto L372;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(final java.lang.String r115, final kotlin.jvm.functions.Function2 r116, final boolean r117, final boolean r118, final androidx.compose.ui.text.input.VisualTransformation r119, final androidx.compose.foundation.interaction.InteractionSource r120, boolean r121, kotlin.jvm.functions.Function2 r122, kotlin.jvm.functions.Function2 r123, kotlin.jvm.functions.Function2 r124, kotlin.jvm.functions.Function2 r125, kotlin.jvm.functions.Function2 r126, androidx.compose.material3.TextFieldColors r127, androidx.compose.foundation.layout.PaddingValues r128, kotlin.jvm.functions.Function2 r129, androidx.compose.runtime.Composer r130, final int r131, final int r132, final int r133) {
        /*
            Method dump skipped, instructions count: 1122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
