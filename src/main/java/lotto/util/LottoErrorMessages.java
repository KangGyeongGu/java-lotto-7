package lotto.util;

public final class LottoErrorMessages {

    public static final String ERROR_LOTTO_PRICE_UNDER_1000 = "금액은 최소 1,000원 이상이어야 합니다.";
    public static final String ERROR_LOTTO_PRICE_UNIT_1000 = "금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_INVALID_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_INVALID_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String ERROR_LOTTO_DUPLICATE_NUMBER = "로또 번호는 중복될 수 없습니다.";

    // 인스턴스 생성 방지
    private LottoErrorMessages() {}
}