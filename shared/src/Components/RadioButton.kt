package evry.thought.captive.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

enum class RadioChoices(val str: String) {
    DESIGN("Design"),
    DESIRE("Desire"),
    GOD("God"),
    HEART("Heart"),
    HOLY("Holy Spirit"),
    ME("Me"),
    NO("No"),
    UNSURE("Unsure"),
    YES("Yes");

    override fun toString() : String {
        return str
    }
}

@Composable
fun RadioButtonSingleSelection(modifier: Modifier = Modifier, radioOptions: List<RadioChoices>, selectedOption: MutableState<RadioChoices>) {
//    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(modifier.selectableGroup()) {
        radioOptions.forEach { radioChoice ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (radioChoice == selectedOption.value),
                        onClick = { selectedOption.value = radioChoice },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (radioChoice == selectedOption.value),
                    onClick = null // null recommended for accessibility with screen readers
                )
                Text(
                    text = radioChoice.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}