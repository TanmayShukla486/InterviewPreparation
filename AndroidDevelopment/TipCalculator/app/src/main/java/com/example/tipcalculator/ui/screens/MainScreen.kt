package com.example.tipcalculator.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.bungeeFamily
import com.example.tipcalculator.ui.theme.ptFamily


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val tipCalculator: (Double, Int) -> Double = { billAmt, tipPercentage ->
        billAmt * tipPercentage / 100
    }
    val perPersonValue = remember {
        mutableDoubleStateOf(0.0)
    }
    val tip = remember {
        mutableDoubleStateOf(0.0)
    }
    val billCalculation: (Double, Int, Int) -> Double = { billAmt, peopleCount, tipPercentage ->
        val totalTips = tipCalculator(billAmt, tipPercentage)
        tip.doubleValue = totalTips
        if (peopleCount > 0) (billAmt + totalTips) / peopleCount else 0.0
    }

    val peopleCount = remember {
        mutableIntStateOf(1)
    }
    val textFieldValue = remember {
        mutableStateOf("")
    }
    val sliderState = remember {
        mutableFloatStateOf(0f)
    }
    val tipPercentage = (sliderState.floatValue * 100).toInt()
    val onTextFieldValueChange: (String) -> Unit = { value ->
        if (value.isNotBlank()) {
            val billAmt = value.toDouble()
            perPersonValue.doubleValue =
                billCalculation(billAmt, peopleCount.intValue, tipPercentage)
        } else {
            tip.doubleValue = 0.0
            perPersonValue.doubleValue = 0.0
        }
    }
    Surface(
        color = Color(0xffeffaf1)
    ) {
        Column {
            Row {
                TipDisplayCard(
                    modifier = modifier.height(175.dp),
                    totalTips = perPersonValue
                )
            }
            Row {
                MainContent(
                    textFieldValue = textFieldValue,
                    onTextFieldChange = onTextFieldValueChange,
                    peopleCount = peopleCount,
                    tip = tip,
                    tipPercentage = tipPercentage,
                    textColor = Color.White,
                    keyboardController = keyboardController,
                    sliderState = sliderState
                )
            }
        }
    }
}

@Composable
fun TipDisplayCard(
    modifier: Modifier = Modifier,
    totalTips: MutableState<Double>
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(175.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(15.dp)),
        color = Color(0xff2D6A4F)
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Total Per Person",
                    style = TextStyle(
                        fontFamily = bungeeFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                    ),
                    color = Color.White
                )
                Text(
                    text = "$" + (Math.round(totalTips.value * 100) / 100.0).toString(),
                    style = TextStyle(
                        fontFamily = bungeeFamily,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                    ),
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    onTextFieldChange: (String) -> Unit = {},
    peopleCount: MutableState<Int>,
    tip: MutableState<Double>,
    tipPercentage: Int,
    textColor: Color,
    keyboardController: SoftwareKeyboardController?,
    sliderState: MutableState<Float>
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(16.dp),
        border = BorderStroke(1.dp, Color.DarkGray),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 8.dp,
        color = Color(0xff95D5B2)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            InputTextField(
                textFieldValue = textFieldValue,
                labelText = "Enter Bill",
                onTextFieldChange = onTextFieldChange, textColor = textColor,
                onAction = KeyboardActions(
                    onNext = { keyboardController?.hide() }
                )
            )
            Spacer(modifier = modifier.height(24.dp))
            SplitPeopleRow(
                peopleCount = peopleCount,
                onPeopleCountChange = { onTextFieldChange.invoke(textFieldValue.value) })
            Spacer(modifier = modifier.height(24.dp))
            CustomDataRow(
                title = "Tip Amount",
                mutableData = tip,
                identifier = "$",
                textColor = textColor
            )
            Spacer(modifier = modifier.height(24.dp))
            TipRow(
                sliderState = sliderState,
                tipPercentage = tipPercentage,
                textColor = textColor,
                onSliderChange = {onTextFieldChange.invoke(textFieldValue.value)}
            )
        }
    }
}

@Composable
fun TipRow(
    modifier: Modifier = Modifier,
    sliderState: MutableState<Float>,
    tipPercentage: Int,
    textColor: Color,
    onSliderChange: () -> Unit
) {
    Surface (
        color = Color(0xff95D5B2)
    ) {
        Column {
            Text(
                modifier = modifier.padding(horizontal = 100.dp),
                text = "Tip Percentage = $tipPercentage",
                fontFamily = ptFamily,
                color = textColor,
                fontSize = 18.sp
            )
            Slider(
                modifier = modifier.padding(horizontal = 16.dp),
                value = sliderState.value,
                onValueChange = {
                sliderState.value = it
                onSliderChange.invoke()
            },
                steps = 10)
        }
    }
}

@Composable
fun CustomDataRow(
    modifier: Modifier = Modifier,
    title: String = "Title",
    mutableData: MutableState<Double>,
    identifier: String,
    textColor: Color,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier.fillMaxWidth(0.6f)
        ) {
            Text(
                text = title,
                fontFamily = ptFamily,
                color = textColor
            )
        }
        Column(modifier = modifier.fillMaxWidth()) {
            Text(
                text = identifier + mutableData.value.toString(),
                fontFamily = ptFamily,
                color = textColor
            )
        }
    }
}

@Composable
fun SplitPeopleRow(
    modifier: Modifier = Modifier,
    peopleCount: MutableState<Int>,
    onPeopleCountChange: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier.fillMaxWidth(0.6f)
        ) {
            Text(text = "Split", fontFamily = ptFamily)
        }
        Column(
            modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = {
                    if (peopleCount.value > 1) {
                        peopleCount.value--
                        onPeopleCountChange.invoke()
                    }
                }) {
                    Icon(imageVector = Icons.Rounded.Remove, contentDescription = null)
                }
                Text(text = peopleCount.value.toString(), fontFamily = ptFamily, fontSize = 18.sp)
                IconButton(onClick = {
                    peopleCount.value++
                    onPeopleCountChange.invoke()
                }) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                }
            }
        }
    }

}

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    labelText: String,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onTextFieldChange: (String) -> Unit,
    textColor: Color,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
            onTextFieldChange.invoke(textFieldValue.value)
        },
        label = {
            Text(
                text = labelText,
                fontFamily = ptFamily,
                color = textColor
            )
        },
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.AttachMoney, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        textStyle = TextStyle(
            fontFamily = ptFamily,
            color = textColor
        ),
        keyboardActions = onAction
    )
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun PreviewMainContent() {
    MainContent(
        textFieldValue = mutableStateOf(""),
        peopleCount = mutableIntStateOf(0),
        tip = mutableDoubleStateOf(0.0),
        tipPercentage = 33,
        textColor = Color.White,
        keyboardController = LocalSoftwareKeyboardController.current,
        sliderState = mutableFloatStateOf(0f)
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun PreviewTipDisplayCard() {
    TipDisplayCard(
        totalTips = mutableDoubleStateOf(0.0)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}