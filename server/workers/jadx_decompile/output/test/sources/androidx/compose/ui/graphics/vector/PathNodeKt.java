package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathNode.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ai\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b28\b\u0004\u0010(\u001a2\u0012\u0013\u0012\u00110%¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\b¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020#0)H\u0082\b\u001a*\u0010.\u001a\u00020 *\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathNodesFromArgs", "", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "count", "numArgs", "nodeFor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "subArray", "start", "addPathNodes", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char $this$addPathNodes, List<PathNode> nodes, float[] args, int count) {
        PathNode.RelativeLineTo relativeLineTo;
        PathNode.RelativeLineTo relativeLineTo2;
        PathNode.RelativeLineTo relativeLineTo3;
        PathNode.RelativeLineTo relativeLineTo4;
        PathNode.RelativeLineTo relativeLineTo5;
        PathNode.RelativeLineTo relativeLineTo6;
        PathNode.RelativeLineTo relativeLineTo7;
        PathNode.RelativeLineTo relativeLineTo8;
        PathNode.RelativeLineTo relativeLineTo9;
        PathNode.RelativeLineTo relativeLineTo10;
        PathNode.RelativeLineTo relativeLineTo11;
        PathNode.RelativeLineTo relativeLineTo12;
        PathNode.RelativeLineTo relativeLineTo13;
        PathNode.RelativeLineTo relativeLineTo14;
        PathNode.RelativeLineTo relativeLineTo15;
        PathNode.RelativeLineTo relativeLineTo16;
        PathNode.RelativeLineTo relativeLineTo17;
        PathNode.RelativeLineTo relativeLineTo18;
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!($this$addPathNodes == 'z' || $this$addPathNodes == 'Z')) {
            if ($this$addPathNodes != 'm') {
                if ($this$addPathNodes != 'M') {
                    if ($this$addPathNodes != 'l') {
                        if ($this$addPathNodes != 'L') {
                            if ($this$addPathNodes != 'h') {
                                if ($this$addPathNodes != 'H') {
                                    if ($this$addPathNodes != 'v') {
                                        if ($this$addPathNodes != 'V') {
                                            if ($this$addPathNodes != 'c') {
                                                if ($this$addPathNodes != 'C') {
                                                    if ($this$addPathNodes != 's') {
                                                        if ($this$addPathNodes != 'S') {
                                                            if ($this$addPathNodes != 'q') {
                                                                if ($this$addPathNodes != 'Q') {
                                                                    if ($this$addPathNodes != 't') {
                                                                        if ($this$addPathNodes != 'T') {
                                                                            if ($this$addPathNodes != 'a') {
                                                                                if ($this$addPathNodes != 'A') {
                                                                                    throw new IllegalArgumentException("Unknown command for: " + $this$addPathNodes);
                                                                                }
                                                                                int end$iv = count - 7;
                                                                                for (int index$iv = 0; index$iv <= end$iv; index$iv += 7) {
                                                                                    int start = index$iv;
                                                                                    PathNode node$iv = new PathNode.ArcTo(args[start], args[start + 1], args[start + 2], Float.compare(args[start + 3], 0.0f) != 0, Float.compare(args[start + 4], 0.0f) != 0, args[start + 5], args[start + 6]);
                                                                                    if ((node$iv instanceof PathNode.MoveTo) && index$iv > 0) {
                                                                                        relativeLineTo = new PathNode.LineTo(args[index$iv], args[index$iv + 1]);
                                                                                    } else if ((node$iv instanceof PathNode.RelativeMoveTo) && index$iv > 0) {
                                                                                        relativeLineTo = new PathNode.RelativeLineTo(args[index$iv], args[index$iv + 1]);
                                                                                    } else {
                                                                                        relativeLineTo = node$iv;
                                                                                    }
                                                                                    nodes.add(relativeLineTo);
                                                                                }
                                                                                return;
                                                                            }
                                                                            int end$iv2 = count - 7;
                                                                            for (int index$iv2 = 0; index$iv2 <= end$iv2; index$iv2 += 7) {
                                                                                int start2 = index$iv2;
                                                                                PathNode node$iv2 = new PathNode.RelativeArcTo(args[start2], args[start2 + 1], args[start2 + 2], Float.compare(args[start2 + 3], 0.0f) != 0, Float.compare(args[start2 + 4], 0.0f) != 0, args[start2 + 5], args[start2 + 6]);
                                                                                if ((node$iv2 instanceof PathNode.MoveTo) && index$iv2 > 0) {
                                                                                    relativeLineTo2 = new PathNode.LineTo(args[index$iv2], args[index$iv2 + 1]);
                                                                                } else if ((node$iv2 instanceof PathNode.RelativeMoveTo) && index$iv2 > 0) {
                                                                                    relativeLineTo2 = new PathNode.RelativeLineTo(args[index$iv2], args[index$iv2 + 1]);
                                                                                } else {
                                                                                    relativeLineTo2 = node$iv2;
                                                                                }
                                                                                nodes.add(relativeLineTo2);
                                                                            }
                                                                            return;
                                                                        }
                                                                        int end$iv3 = count - 2;
                                                                        for (int index$iv3 = 0; index$iv3 <= end$iv3; index$iv3 += 2) {
                                                                            int start3 = index$iv3;
                                                                            PathNode node$iv3 = new PathNode.ReflectiveQuadTo(args[start3], args[start3 + 1]);
                                                                            if ((node$iv3 instanceof PathNode.MoveTo) && index$iv3 > 0) {
                                                                                relativeLineTo3 = new PathNode.LineTo(args[index$iv3], args[index$iv3 + 1]);
                                                                            } else if ((node$iv3 instanceof PathNode.RelativeMoveTo) && index$iv3 > 0) {
                                                                                relativeLineTo3 = new PathNode.RelativeLineTo(args[index$iv3], args[index$iv3 + 1]);
                                                                            } else {
                                                                                relativeLineTo3 = node$iv3;
                                                                            }
                                                                            nodes.add(relativeLineTo3);
                                                                        }
                                                                        return;
                                                                    }
                                                                    int end$iv4 = count - 2;
                                                                    for (int index$iv4 = 0; index$iv4 <= end$iv4; index$iv4 += 2) {
                                                                        int start4 = index$iv4;
                                                                        PathNode node$iv4 = new PathNode.RelativeReflectiveQuadTo(args[start4], args[start4 + 1]);
                                                                        if ((node$iv4 instanceof PathNode.MoveTo) && index$iv4 > 0) {
                                                                            relativeLineTo4 = new PathNode.LineTo(args[index$iv4], args[index$iv4 + 1]);
                                                                        } else if ((node$iv4 instanceof PathNode.RelativeMoveTo) && index$iv4 > 0) {
                                                                            relativeLineTo4 = new PathNode.RelativeLineTo(args[index$iv4], args[index$iv4 + 1]);
                                                                        } else {
                                                                            relativeLineTo4 = node$iv4;
                                                                        }
                                                                        nodes.add(relativeLineTo4);
                                                                    }
                                                                    return;
                                                                }
                                                                int end$iv5 = count - 4;
                                                                for (int index$iv5 = 0; index$iv5 <= end$iv5; index$iv5 += 4) {
                                                                    int start5 = index$iv5;
                                                                    PathNode node$iv5 = new PathNode.QuadTo(args[start5], args[start5 + 1], args[start5 + 2], args[start5 + 3]);
                                                                    if ((node$iv5 instanceof PathNode.MoveTo) && index$iv5 > 0) {
                                                                        relativeLineTo5 = new PathNode.LineTo(args[index$iv5], args[index$iv5 + 1]);
                                                                    } else if ((node$iv5 instanceof PathNode.RelativeMoveTo) && index$iv5 > 0) {
                                                                        relativeLineTo5 = new PathNode.RelativeLineTo(args[index$iv5], args[index$iv5 + 1]);
                                                                    } else {
                                                                        relativeLineTo5 = node$iv5;
                                                                    }
                                                                    nodes.add(relativeLineTo5);
                                                                }
                                                                return;
                                                            }
                                                            int end$iv6 = count - 4;
                                                            for (int index$iv6 = 0; index$iv6 <= end$iv6; index$iv6 += 4) {
                                                                int start6 = index$iv6;
                                                                PathNode node$iv6 = new PathNode.RelativeQuadTo(args[start6], args[start6 + 1], args[start6 + 2], args[start6 + 3]);
                                                                if ((node$iv6 instanceof PathNode.MoveTo) && index$iv6 > 0) {
                                                                    relativeLineTo6 = new PathNode.LineTo(args[index$iv6], args[index$iv6 + 1]);
                                                                } else if ((node$iv6 instanceof PathNode.RelativeMoveTo) && index$iv6 > 0) {
                                                                    relativeLineTo6 = new PathNode.RelativeLineTo(args[index$iv6], args[index$iv6 + 1]);
                                                                } else {
                                                                    relativeLineTo6 = node$iv6;
                                                                }
                                                                nodes.add(relativeLineTo6);
                                                            }
                                                            return;
                                                        }
                                                        int end$iv7 = count - 4;
                                                        for (int index$iv7 = 0; index$iv7 <= end$iv7; index$iv7 += 4) {
                                                            int start7 = index$iv7;
                                                            PathNode node$iv7 = new PathNode.ReflectiveCurveTo(args[start7], args[start7 + 1], args[start7 + 2], args[start7 + 3]);
                                                            if ((node$iv7 instanceof PathNode.MoveTo) && index$iv7 > 0) {
                                                                relativeLineTo7 = new PathNode.LineTo(args[index$iv7], args[index$iv7 + 1]);
                                                            } else if ((node$iv7 instanceof PathNode.RelativeMoveTo) && index$iv7 > 0) {
                                                                relativeLineTo7 = new PathNode.RelativeLineTo(args[index$iv7], args[index$iv7 + 1]);
                                                            } else {
                                                                relativeLineTo7 = node$iv7;
                                                            }
                                                            nodes.add(relativeLineTo7);
                                                        }
                                                        return;
                                                    }
                                                    int end$iv8 = count - 4;
                                                    for (int index$iv8 = 0; index$iv8 <= end$iv8; index$iv8 += 4) {
                                                        int start8 = index$iv8;
                                                        PathNode node$iv8 = new PathNode.RelativeReflectiveCurveTo(args[start8], args[start8 + 1], args[start8 + 2], args[start8 + 3]);
                                                        if ((node$iv8 instanceof PathNode.MoveTo) && index$iv8 > 0) {
                                                            relativeLineTo8 = new PathNode.LineTo(args[index$iv8], args[index$iv8 + 1]);
                                                        } else if ((node$iv8 instanceof PathNode.RelativeMoveTo) && index$iv8 > 0) {
                                                            relativeLineTo8 = new PathNode.RelativeLineTo(args[index$iv8], args[index$iv8 + 1]);
                                                        } else {
                                                            relativeLineTo8 = node$iv8;
                                                        }
                                                        nodes.add(relativeLineTo8);
                                                    }
                                                    return;
                                                }
                                                int end$iv9 = count - 6;
                                                for (int index$iv9 = 0; index$iv9 <= end$iv9; index$iv9 += 6) {
                                                    int start9 = index$iv9;
                                                    PathNode node$iv9 = new PathNode.CurveTo(args[start9], args[start9 + 1], args[start9 + 2], args[start9 + 3], args[start9 + 4], args[start9 + 5]);
                                                    if ((node$iv9 instanceof PathNode.MoveTo) && index$iv9 > 0) {
                                                        relativeLineTo9 = new PathNode.LineTo(args[index$iv9], args[index$iv9 + 1]);
                                                    } else if ((node$iv9 instanceof PathNode.RelativeMoveTo) && index$iv9 > 0) {
                                                        relativeLineTo9 = new PathNode.RelativeLineTo(args[index$iv9], args[index$iv9 + 1]);
                                                    } else {
                                                        relativeLineTo9 = node$iv9;
                                                    }
                                                    nodes.add(relativeLineTo9);
                                                }
                                                return;
                                            }
                                            int end$iv10 = count - 6;
                                            for (int index$iv10 = 0; index$iv10 <= end$iv10; index$iv10 += 6) {
                                                int start10 = index$iv10;
                                                PathNode node$iv10 = new PathNode.RelativeCurveTo(args[start10], args[start10 + 1], args[start10 + 2], args[start10 + 3], args[start10 + 4], args[start10 + 5]);
                                                if ((node$iv10 instanceof PathNode.MoveTo) && index$iv10 > 0) {
                                                    relativeLineTo10 = new PathNode.LineTo(args[index$iv10], args[index$iv10 + 1]);
                                                } else if ((node$iv10 instanceof PathNode.RelativeMoveTo) && index$iv10 > 0) {
                                                    relativeLineTo10 = new PathNode.RelativeLineTo(args[index$iv10], args[index$iv10 + 1]);
                                                } else {
                                                    relativeLineTo10 = node$iv10;
                                                }
                                                nodes.add(relativeLineTo10);
                                            }
                                            return;
                                        }
                                        int end$iv11 = count - 1;
                                        for (int index$iv11 = 0; index$iv11 <= end$iv11; index$iv11++) {
                                            PathNode node$iv11 = new PathNode.VerticalTo(args[index$iv11]);
                                            if ((node$iv11 instanceof PathNode.MoveTo) && index$iv11 > 0) {
                                                relativeLineTo11 = new PathNode.LineTo(args[index$iv11], args[index$iv11 + 1]);
                                            } else if ((node$iv11 instanceof PathNode.RelativeMoveTo) && index$iv11 > 0) {
                                                relativeLineTo11 = new PathNode.RelativeLineTo(args[index$iv11], args[index$iv11 + 1]);
                                            } else {
                                                relativeLineTo11 = node$iv11;
                                            }
                                            nodes.add(relativeLineTo11);
                                        }
                                        return;
                                    }
                                    int end$iv12 = count - 1;
                                    for (int index$iv12 = 0; index$iv12 <= end$iv12; index$iv12++) {
                                        PathNode node$iv12 = new PathNode.RelativeVerticalTo(args[index$iv12]);
                                        if ((node$iv12 instanceof PathNode.MoveTo) && index$iv12 > 0) {
                                            relativeLineTo12 = new PathNode.LineTo(args[index$iv12], args[index$iv12 + 1]);
                                        } else if ((node$iv12 instanceof PathNode.RelativeMoveTo) && index$iv12 > 0) {
                                            relativeLineTo12 = new PathNode.RelativeLineTo(args[index$iv12], args[index$iv12 + 1]);
                                        } else {
                                            relativeLineTo12 = node$iv12;
                                        }
                                        nodes.add(relativeLineTo12);
                                    }
                                    return;
                                }
                                int end$iv13 = count - 1;
                                for (int index$iv13 = 0; index$iv13 <= end$iv13; index$iv13++) {
                                    PathNode node$iv13 = new PathNode.HorizontalTo(args[index$iv13]);
                                    if ((node$iv13 instanceof PathNode.MoveTo) && index$iv13 > 0) {
                                        relativeLineTo13 = new PathNode.LineTo(args[index$iv13], args[index$iv13 + 1]);
                                    } else if ((node$iv13 instanceof PathNode.RelativeMoveTo) && index$iv13 > 0) {
                                        relativeLineTo13 = new PathNode.RelativeLineTo(args[index$iv13], args[index$iv13 + 1]);
                                    } else {
                                        relativeLineTo13 = node$iv13;
                                    }
                                    nodes.add(relativeLineTo13);
                                }
                                return;
                            }
                            int end$iv14 = count - 1;
                            for (int index$iv14 = 0; index$iv14 <= end$iv14; index$iv14++) {
                                PathNode node$iv14 = new PathNode.RelativeHorizontalTo(args[index$iv14]);
                                if ((node$iv14 instanceof PathNode.MoveTo) && index$iv14 > 0) {
                                    relativeLineTo14 = new PathNode.LineTo(args[index$iv14], args[index$iv14 + 1]);
                                } else if ((node$iv14 instanceof PathNode.RelativeMoveTo) && index$iv14 > 0) {
                                    relativeLineTo14 = new PathNode.RelativeLineTo(args[index$iv14], args[index$iv14 + 1]);
                                } else {
                                    relativeLineTo14 = node$iv14;
                                }
                                nodes.add(relativeLineTo14);
                            }
                            return;
                        }
                        int end$iv15 = count - 2;
                        for (int index$iv15 = 0; index$iv15 <= end$iv15; index$iv15 += 2) {
                            int start11 = index$iv15;
                            PathNode node$iv15 = new PathNode.LineTo(args[start11], args[start11 + 1]);
                            if ((node$iv15 instanceof PathNode.MoveTo) && index$iv15 > 0) {
                                relativeLineTo15 = new PathNode.LineTo(args[index$iv15], args[index$iv15 + 1]);
                            } else if ((node$iv15 instanceof PathNode.RelativeMoveTo) && index$iv15 > 0) {
                                relativeLineTo15 = new PathNode.RelativeLineTo(args[index$iv15], args[index$iv15 + 1]);
                            } else {
                                relativeLineTo15 = node$iv15;
                            }
                            nodes.add(relativeLineTo15);
                        }
                        return;
                    }
                    int end$iv16 = count - 2;
                    for (int index$iv16 = 0; index$iv16 <= end$iv16; index$iv16 += 2) {
                        int start12 = index$iv16;
                        PathNode node$iv16 = new PathNode.RelativeLineTo(args[start12], args[start12 + 1]);
                        if ((node$iv16 instanceof PathNode.MoveTo) && index$iv16 > 0) {
                            relativeLineTo16 = new PathNode.LineTo(args[index$iv16], args[index$iv16 + 1]);
                        } else if ((node$iv16 instanceof PathNode.RelativeMoveTo) && index$iv16 > 0) {
                            relativeLineTo16 = new PathNode.RelativeLineTo(args[index$iv16], args[index$iv16 + 1]);
                        } else {
                            relativeLineTo16 = node$iv16;
                        }
                        nodes.add(relativeLineTo16);
                    }
                    return;
                }
                int end$iv17 = count - 2;
                for (int index$iv17 = 0; index$iv17 <= end$iv17; index$iv17 += 2) {
                    int start13 = index$iv17;
                    PathNode node$iv17 = new PathNode.MoveTo(args[start13], args[start13 + 1]);
                    if (index$iv17 > 0) {
                        relativeLineTo17 = new PathNode.LineTo(args[index$iv17], args[index$iv17 + 1]);
                    } else if ((node$iv17 instanceof PathNode.RelativeMoveTo) && index$iv17 > 0) {
                        relativeLineTo17 = new PathNode.RelativeLineTo(args[index$iv17], args[index$iv17 + 1]);
                    } else {
                        relativeLineTo17 = node$iv17;
                    }
                    nodes.add(relativeLineTo17);
                }
                return;
            }
            int end$iv18 = count - 2;
            for (int index$iv18 = 0; index$iv18 <= end$iv18; index$iv18 += 2) {
                int start14 = index$iv18;
                PathNode node$iv18 = new PathNode.RelativeMoveTo(args[start14], args[start14 + 1]);
                if ((node$iv18 instanceof PathNode.MoveTo) && index$iv18 > 0) {
                    relativeLineTo18 = new PathNode.LineTo(args[index$iv18], args[index$iv18 + 1]);
                } else if (index$iv18 > 0) {
                    relativeLineTo18 = new PathNode.RelativeLineTo(args[index$iv18], args[index$iv18 + 1]);
                } else {
                    relativeLineTo18 = node$iv18;
                }
                nodes.add(relativeLineTo18);
            }
            return;
        }
        nodes.add(PathNode.Close.INSTANCE);
    }

    private static final void pathNodesFromArgs(List<PathNode> list, float[] args, int count, int numArgs, Function2<? super float[], ? super Integer, ? extends PathNode> function2) {
        PathNode.RelativeLineTo relativeLineTo;
        int end = count - numArgs;
        int index = 0;
        while (index <= end) {
            PathNode node = function2.invoke(args, Integer.valueOf(index));
            if ((node instanceof PathNode.MoveTo) && index > 0) {
                relativeLineTo = new PathNode.LineTo(args[index], args[index + 1]);
            } else if ((node instanceof PathNode.RelativeMoveTo) && index > 0) {
                relativeLineTo = new PathNode.RelativeLineTo(args[index], args[index + 1]);
            } else {
                relativeLineTo = node;
            }
            list.add(relativeLineTo);
            index += numArgs;
        }
    }
}
