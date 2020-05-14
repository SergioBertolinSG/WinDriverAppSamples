//******************************************************************************
//
// Copyright (c) 2016 Microsoft Corporation. All rights reserved.
//
// This code is licensed under the MIT License (MIT).
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//
//******************************************************************************

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTest {

    private static WindowsDriver CalculatorSession = null;
    private static WebElement CalculatorResult = null;

    public static final String CLEAR_ID = "clearButton";
    public static final String NUM0_ID = "num0Button";
    public static final String NUM1_ID = "num1Button";
    public static final String NUM2_ID = "num2Button";
    public static final String NUM3_ID = "num3Button";
    public static final String NUM4_ID = "num4Button";
    public static final String NUM5_ID = "num5Button";
    public static final String NUM6_ID = "num6Button";
    public static final String NUM7_ID = "num7Button";
    public static final String NUM8_ID = "num8Button";
    public static final String NUM9_ID = "num9Button";
    public static final String MULTIPLY_ID = "multiplyButton";
    public static final String PLUS_ID = "plusButton";
    public static final String EQUAL_ID = "equalButton";
    public static final String DIVIDE_ID = "divideButton";
    public static final String MINUS_ID = "minusButton";
    public static final String PREFIX_TEXT_CALC_DISPLAY = "La pantalla muestra";


    @BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(CalculatorResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @Before
    public void Clear()
    {
        CalculatorSession.findElementByAccessibilityId(CLEAR_ID).click();
        Assert.assertEquals("0", _GetCalculatorResultText());
    }

    @AfterClass
    public static void TearDown()
    {
        CalculatorResult = null;
        if (CalculatorSession != null) {
            CalculatorSession.quit();
        }
        CalculatorSession = null;
    }

    @Test
    public void Addition()
    {
        CalculatorSession.findElementByAccessibilityId(NUM1_ID).click();
        CalculatorSession.findElementByAccessibilityId(PLUS_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM7_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    @Test
    public void Combination()
    {
        CalculatorSession.findElementByAccessibilityId(NUM7_ID).click();
        CalculatorSession.findElementByAccessibilityId(MULTIPLY_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM9_ID).click();
        CalculatorSession.findElementByAccessibilityId(PLUS_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM1_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        CalculatorSession.findElementByAccessibilityId(DIVIDE_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM8_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    @Test
    public void Division()
    {
        CalculatorSession.findElementByAccessibilityId(NUM8_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM8_ID).click();
        CalculatorSession.findElementByAccessibilityId(DIVIDE_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM1_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM1_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    @Test
    public void Multiplication()
    {
        CalculatorSession.findElementByAccessibilityId(NUM9_ID).click();
        CalculatorSession.findElementByAccessibilityId(MULTIPLY_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM9_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        Assert.assertEquals("81", _GetCalculatorResultText());
    }

    @Test
    public void Subtraction()
    {
        CalculatorSession.findElementByAccessibilityId(NUM9_ID).click();
        CalculatorSession.findElementByAccessibilityId(MINUS_ID).click();
        CalculatorSession.findElementByAccessibilityId(NUM1_ID).click();
        CalculatorSession.findElementByAccessibilityId(EQUAL_ID).click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace(PREFIX_TEXT_CALC_DISPLAY, "").trim();
    }

}
