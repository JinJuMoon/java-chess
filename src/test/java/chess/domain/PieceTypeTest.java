//package chess.domain;
//
//import chess.domain.position.Position;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Arrays;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//
//class PieceTypeTest {
//    @ParameterizedTest
//    @MethodSource("createFromPositionAndToPosition")
//    void 비숍이_fromPosition에서_toPosition으로_움직이는_경로_확인(Position fromPosition, Position toPosition, Route expected) {
//        PieceType bishop = PieceType.BISHOP;
//
//        Route actual = bishop.findRoute(fromPosition, toPosition, Team.WHITE);
//
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    private static Stream<Arguments> createFromPositionAndToPosition() {
//        return Stream.of(
//                Arguments.of(Position.of("e5"), Position.of("a1"), new Route(Arrays.asList(
//                        Position.of("d4"),
//                        Position.of("c3"),
//                        Position.of("b2"),
//                        Position.of("a1")))),
//
//                Arguments.of(Position.of("e5"), Position.of("h2"), new Route(Arrays.asList(
//                        Position.of("f4"),
//                        Position.of("g3"),
//                        Position.of("h2")))),
//
//                Arguments.of(Position.of("e5"), Position.of("b8"), new Route(Arrays.asList(
//                        Position.of("d6"),
//                        Position.of("c7"),
//                        Position.of("b8")))),
//
//
//                Arguments.of(Position.of("e5"), Position.of("h8"), new Route(Arrays.asList(
//                        Position.of("f6"),
//                        Position.of("g7"),
//                        Position.of("h8"))))
//        );
//    }
//
//    @ParameterizedTest
//    @CsvSource(value = {"true:0.5", "false:1.0"}, delimiter = ':')
//    void 인자있는_score_폰인_경우(boolean mustChange, double expected) {
//        assertThat(PieceType.PAWN.score(mustChange)).isEqualTo(expected);
//    }
//
//    @ParameterizedTest
//    @MethodSource("pieceTypesExceptPawn")
//    void 인자있는_score_폰이_아닌_경우_예외처리(PieceType pieceType) {
//        assertThatThrownBy(() -> {
//            pieceType.score(true);
//        }).isInstanceOf(UnsupportedOperationException.class);
//    }
//
//    private static Stream<Arguments> pieceTypesExceptPawn() {
//        return Stream.of(
//                Arguments.of(PieceType.BISHOP),
//                Arguments.of(PieceType.KING),
//                Arguments.of(PieceType.KNIGHT),
//                Arguments.of(PieceType.QUEEN),
//                Arguments.of(PieceType.ROOK)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("pieceTypesExceptPawnWithScore")
//    void 인자없는_score_폰이_아닌_경우(PieceType pieceType, double expected) {
//        assertThat(pieceType.score()).isEqualTo(expected);
//    }
//
//    private static Stream<Arguments> pieceTypesExceptPawnWithScore() {
//        return Stream.of(
//                Arguments.of(PieceType.BISHOP, 3.0),
//                Arguments.of(PieceType.KING, 0.0),
//                Arguments.of(PieceType.KNIGHT, 2.5),
//                Arguments.of(PieceType.QUEEN, 9.0),
//                Arguments.of(PieceType.ROOK, 5.0)
//        );
//    }
//
//    @Test
//    void 인자없는_score_폰인_경우_예외처리() {
//        assertThatThrownBy(() -> {
//            PieceType.PAWN.score();
//        }).isInstanceOf(UnsupportedOperationException.class);
//    }
//
//    @ParameterizedTest
//    @MethodSource("createPieceTypeAndAcronymToUpperCase")
//    void 표현문자를_대문자로_얻기(PieceType pieceType, String expected) {
//        assertThat(pieceType.getAcronymToUpperCase())
//                .isEqualTo(expected);
//    }
//
//    private static Stream<Arguments> createPieceTypeAndAcronymToUpperCase() {
//        return Stream.of(
//                Arguments.of(PieceType.KING, "K"),
//                Arguments.of(PieceType.QUEEN, "Q"),
//                Arguments.of(PieceType.KNIGHT, "N"),
//                Arguments.of(PieceType.ROOK, "R"),
//                Arguments.of(PieceType.BISHOP, "B"),
//                Arguments.of(PieceType.PAWN, "P")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("createPieceTypeAndAcronymToLowerCase")
//    void 표현문자를_소문자로_얻기(PieceType pieceType, String expected) {
//        assertThat(pieceType.getAcronymToLowerCase())
//                .isEqualTo(expected);
//    }
//
//    private static Stream<Arguments> createPieceTypeAndAcronymToLowerCase() {
//        return Stream.of(
//                Arguments.of(PieceType.KING, "k"),
//                Arguments.of(PieceType.QUEEN, "q"),
//                Arguments.of(PieceType.KNIGHT, "n"),
//                Arguments.of(PieceType.ROOK, "r"),
//                Arguments.of(PieceType.BISHOP, "b"),
//                Arguments.of(PieceType.PAWN, "p")
//        );
//    }
//}
